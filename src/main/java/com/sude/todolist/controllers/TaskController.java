package com.sude.todolist.controllers;

import com.sude.todolist.core.Response;
import com.sude.todolist.dtos.TaskAddDto;
import com.sude.todolist.entities.Task;
import com.sude.todolist.services.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
@CrossOrigin(origins = "http://localhost:3000")
public class TaskController {

    @Autowired
    private TaskService taskService;


    @GetMapping
    public List<Task>getAll(){
        return taskService.getAll();
    }
    @GetMapping(path = "/findBytodolistId")
    public List<Task> findBytodolistId(@RequestParam Long todolistId) {
        return taskService.findBytodolistId(todolistId);
    }
    @PostMapping
    public Response<Task> add(@RequestBody TaskAddDto taskAddDto) {
        return taskService.add(taskAddDto);
    }
}
