package com.zeze.springboot.dao;

import com.zeze.springboot.entity.Course;
import com.zeze.springboot.entity.Instructor;
import com.zeze.springboot.entity.InstructorDetail;
import com.zeze.springboot.entity.StudentJPAMapping;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class AppDAOImpl implements AppDAO{

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);
    }

    @Override
    @Transactional
    public void deleteInstructorById(int id) {
        Instructor instructorById = findInstructorById(id);
        List<Course> coursesByInstructorId = findCoursesByInstructorId(instructorById.getId());
        for (Course course : coursesByInstructorId){
            course.setInstructor(null);
        }
        entityManager.remove(instructorById);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    @Transactional
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail instructorDetail = entityManager.find(InstructorDetail.class, theId);
        List<Course> coursesByInstructorId = findCoursesByInstructorId(instructorDetail.getId());
        for (Course course : coursesByInstructorId){
            course.setInstructor(null);
        }
        instructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);
        List<Course> courses = query.getResultList();
        return courses;
    }

    @Override
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery("select i from Instructor i JOIN FETCH i.courses JOIN FETCH i.instructorDetail where i.id = :data", Instructor.class);
        query.setParameter("data", theId);
        Instructor instructor = query.getSingleResult();
        return instructor;
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);
    }

    @Override
    @Transactional
    public void updateCourse(Course tempCourse) {
        entityManager.merge(tempCourse);
    }

    @Override
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);
    }

    @Override
    @Transactional
    public void deleteCourseById(int id) {
        Course courseById = findCourseById(id);
        entityManager.remove(courseById);
    }

    @Override
    @Transactional
    public void save(Course theCourse) {
        entityManager.persist(theCourse);
    }

    @Override
    public Course findCourseAndReviewsByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c JOIN FETCH c.reviews where c.id = :data", Course.class);
        query.setParameter("data", theId);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public Course findCourseAndStudentByCourseId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery("select c from Course c JOIN FETCH c.studentJPAMappings where c.id = :data", Course.class);
        query.setParameter("data", theId);
        Course course = query.getSingleResult();
        return course;
    }

    @Override
    public StudentJPAMapping findCourseAndStudentByStudentId(int theId) {
        TypedQuery<StudentJPAMapping> query = entityManager.createQuery("select c from StudentJPAMapping c JOIN FETCH c.courses where c.id = :data", StudentJPAMapping.class);
        query.setParameter("data", theId);
        StudentJPAMapping course = query.getSingleResult();
        return course;
    }

    @Override
    @Transactional
    public void update(StudentJPAMapping tempStudent) {
        entityManager.merge(tempStudent);

    }

    @Override
    @Transactional
    public void deleteStudentById(int theId) {
        StudentJPAMapping tempStudent = entityManager.find(StudentJPAMapping.class, 3);
        entityManager.remove(tempStudent);
    }
}
