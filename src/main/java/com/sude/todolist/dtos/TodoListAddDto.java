package com.sude.todolist.dtos;

public class TodoListAddDto {
    private String name;
    private Long userId;

    public TodoListAddDto() {
    }

    public TodoListAddDto(String name, Long userId) {
        this.name = name;
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
