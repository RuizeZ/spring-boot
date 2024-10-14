package com.zeze.springboot.rest;

import com.zeze.springboot.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentRestController {
    private List<Student> theStudents;
    @PostConstruct
    public void loadData(){
        theStudents = new ArrayList<>();
        theStudents.add(new Student("Ruize", "Zhang"));
        theStudents.add(new Student("Zeze", "Zhang"));
        theStudents.add(new Student("Steve", "Zhang"));
    }
    @GetMapping("/students")
    public List<Student> getStudent(){
        return theStudents;
    }

    @GetMapping("/student/{studentId}")
    public Student getStudent(@PathVariable int studentId){
        if (studentId >= theStudents.size() || studentId < 0){
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }
        return theStudents.get(studentId);
    }
}
