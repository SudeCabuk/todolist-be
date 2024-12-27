package com.sude.todolist.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column(unique = true) //benzersiz
    private String email;

    @Column
    private String password;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference
    private List<TodoList> todoLists;


}
