package com.sude.todolist.services;

import com.sude.todolist.core.Response;
import com.sude.todolist.dataAccess.TodoListRepository;
import com.sude.todolist.dataAccess.UserRepository;

import com.sude.todolist.dtos.TodoListAddDto;
import com.sude.todolist.entities.TodoList;
import com.sude.todolist.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoListService {

     @Autowired
     private TodoListRepository todoListRepository;

     @Autowired
     private UserRepository userRepository;

     public List<TodoList> getAll() {
         return todoListRepository.findAll();
     }

     public List<TodoList> findByUserId(Long userId){
         return todoListRepository.findByUserId(userId);
     }

    public Response<TodoList> add(TodoListAddDto todoListAddDto) {
        TodoList todoList = new TodoList();
        todoList.setName(todoListAddDto.getName());
        todoList.setUser(userRepository.findById(todoListAddDto.getUserId()).get());

         todoListRepository.save(todoList);

        Response<TodoList> response = new Response<>();
        response.setMessage("Görev başarıyla eklendi");
        response.setSuccess(true);
        response.setData(todoList);

        return response;
    }
}
