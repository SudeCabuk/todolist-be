package com.sude.todolist.dataAccess;

import com.sude.todolist.entities.TodoList;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoListRepository extends JpaRepository<TodoList,Long> {
    List<TodoList> findByUserId(Long id);
}
