package com.zeze.springboot.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="course")
@Data
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "instructor_id")
    @ToString.Exclude
    private Instructor instructor;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "course_student",
               joinColumns = @JoinColumn(name = "course_id"),
               inverseJoinColumns = @JoinColumn(name = "student_id"))
    @ToString.Exclude
    private List<StudentJPAMapping> studentJPAMappings;

    public void addReview(Review review){
        if(reviews == null){
            reviews = new ArrayList<>();
        }
        reviews.add(review);
    }


    public void addStudent(StudentJPAMapping theStudentJPAMapping){
        if(studentJPAMappings == null){
            studentJPAMappings = new ArrayList<>();
        }
        studentJPAMappings.add(theStudentJPAMapping);
    }

    public Course() {
    }

    public Course(String title) {
        this.title = title;
    }
}
