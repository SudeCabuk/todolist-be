package com.sude.todolist.services;

import com.sude.todolist.core.Response;
import com.sude.todolist.dataAccess.TaskRepository;
import com.sude.todolist.dataAccess.TodoListRepository;
import com.sude.todolist.dtos.TaskAddDto;
import com.sude.todolist.entities.Task;
import com.sude.todolist.entities.TodoList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private TodoListRepository todoListRepository;

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public List<Task> findBytodolistId(Long todolistId) {
        return taskRepository.findByTodoListId(todolistId);
    }

    public Response<Task> add(TaskAddDto taskAddDto) {
        Task task = new Task();
        task.setTitle(taskAddDto.getTitle());
        task.setDescription(taskAddDto.getDescription());

        task.setTodoList(todoListRepository.findById(taskAddDto.getTodolistId()).get());

        Task addedTask = taskRepository.save(task);

        Response<Task> response = new Response<>();
        response.setMessage("Görev başarıyla eklendi");
        response.setSuccess(true);
        response.setData(addedTask);

        return response;
    }
}
