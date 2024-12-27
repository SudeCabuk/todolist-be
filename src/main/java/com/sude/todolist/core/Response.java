package com.sude.todolist.core;

public class Response<T> {
    private String message;
    private boolean isSuccess;
    private T data;

    public Response() {
    }

    public Response(String message, boolean isSuccess, T data) {
        this.message = message;
        this.isSuccess = isSuccess;
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
