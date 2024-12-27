package com.sude.todolist.dataAccess;

import com.sude.todolist.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> {
    List<Task> findByTodoListId(Long todolistId);
}
