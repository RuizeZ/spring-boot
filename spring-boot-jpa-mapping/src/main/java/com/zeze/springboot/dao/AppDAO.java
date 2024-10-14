package com.zeze.springboot.dao;

import com.zeze.springboot.entity.Course;
import com.zeze.springboot.entity.Instructor;
import com.zeze.springboot.entity.InstructorDetail;
import com.zeze.springboot.entity.StudentJPAMapping;

import java.util.List;

public interface AppDAO {
    void save(Instructor theInstructor);

    Instructor findInstructorById(int id);

    void deleteInstructorById(int id);

    InstructorDetail findInstructorDetailById(int theId);

    void deleteInstructorDetailById(int theId);

    List<Course> findCoursesByInstructorId(int theId);

    Instructor findInstructorByIdJoinFetch(int theId);

    void update(Instructor instructor);

    void updateCourse(Course tempCourse);

    Course findCourseById(int id);

    void deleteCourseById(int id);

    void save(Course theCourse);

    Course findCourseAndReviewsByCourseId(int theId);
    Course findCourseAndStudentByCourseId(int theId);
    StudentJPAMapping findCourseAndStudentByStudentId(int theId);

    void update(StudentJPAMapping tempStudent);

    void deleteStudentById(int theId);

}
