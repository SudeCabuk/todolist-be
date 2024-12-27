package com.sude.todolist.controllers;

import com.sude.todolist.core.Response;
import com.sude.todolist.entities.User;
import com.sude.todolist.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/users")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAll() {
        return userService.getAll();
    }
    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }
    @PostMapping("/register")
    public Response<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }
    @PostMapping("/login")
    public Response<User> loginUser(@RequestBody User user) {
        return userService.validateUser(user.getEmail(), user.getPassword());
    }

}
