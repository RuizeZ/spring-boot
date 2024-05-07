package com.zeze.crud.dao;

import com.zeze.crud.entity.Student;

import java.util.List;

public interface StudentDAO {
    void save (Student theStudent);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);
}
