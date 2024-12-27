package com.sude.todolist.controllers;

import com.sude.todolist.core.Response;
import com.sude.todolist.dtos.TodoListAddDto;
import com.sude.todolist.entities.TodoList;
import com.sude.todolist.services.TodoListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/todolist")
@CrossOrigin
public class TodoListController {
    @Autowired
    private TodoListService todoListService;

    @GetMapping
    public List<TodoList> getAll(){
        return todoListService.getAll();
    }

    @GetMapping(path = "/findByUserId")
    public List<TodoList> findByUserId(@RequestParam Long userId){
        return todoListService.findByUserId(userId);
    }

    @PostMapping
    public Response<TodoList> add(@RequestBody TodoListAddDto todoListAddDto) {
        return todoListService.add(todoListAddDto);
    }

}
