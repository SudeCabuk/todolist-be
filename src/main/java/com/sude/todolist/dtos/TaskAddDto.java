package com.sude.todolist.dtos;

public class TaskAddDto {
    private String title;
    private String description;
    private Long todolistId;

    public TaskAddDto() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getTodolistId() {
        return todolistId;
    }

    public void setTodolistId(Long todolistId) {
        this.todolistId = todolistId;
    }

    public TaskAddDto(String description, Long todolistId, String title) {
        this.description = description;
        this.todolistId = todolistId;
        this.title = title;
    }
}

