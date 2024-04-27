package com.zeze.crud.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "student")
public class Student {
    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    // must define a no-argument constructor
    public Student() {}
    public Student(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }
}
