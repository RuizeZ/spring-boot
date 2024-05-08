package com.zeze.springboot;

import com.zeze.crud.dao.StudentDAO;
import com.zeze.crud.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zeze.crud", "com.zeze.springboot"})
@EntityScan(basePackages = "com.zeze.crud.entity")
public class SpringbootApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
	//
	// Simulate the application shutting down
	// -- sleep for 5 seconds
	// -- then System.exit(0);
//	@Bean
//	public CommandLineRunner commandLineRunner() {
//		return runner -> {
//			System.out.println("Sleeping for 5 seconds");
//			Thread.sleep(5000);
//			System.out.println("We are closing the office. Time to exit.");
//			System.exit(0);
//		};
//	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
//			createStudent(studentDAO);
//			createMultipleStudents(studentDAO);
//			readStudent(studentDAO);
//			queryForStudents(studentDAO);
//			queryForStudentsByLastName(studentDAO);
//			update(studentDAO);
//			delete(studentDAO);
			deleteAll(studentDAO);
		};
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println(studentDAO.deleteAll());
	}

	private void delete(StudentDAO studentDAO) {
		studentDAO.delete(1);
	}

	private void update(StudentDAO studentDAO) {
		Student student = studentDAO.findById(1);
		student.setLastName("zeze");
		studentDAO.update(student);
		System.out.println(studentDAO.findById(1));
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {
		List<Student> students = studentDAO.findByLastName("zhang");
		for (Student student :
				students) {
			System.out.println(student);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> theStudents = studentDAO.findAll();
		for (Student student :
				theStudents) {
			System.out.println(student);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		System.out.println("Creating the student");
		Student tempStudent = new Student("test", "test", "test ");
		System.out.println("saving student");
		studentDAO.save(tempStudent);
		System.out.println("student Id: " + tempStudent.getId());
		System.out.println(studentDAO.findById(tempStudent.getId()));
	}

	private void createMultipleStudents(StudentDAO studentDAO) {
//		System.out.println("Creating the student");
//		Student tempStudent1 = new Student("test", "test", "test ");
//		System.out.println("saving student");
//		studentDAO.save(tempStudent1);
//		System.out.println("student Id: " + tempStudent1.getId());
//		Student tempStudent2 = new Student("test2", "test", "test ");
//		System.out.println("saving student");
//		studentDAO.save(tempStudent2);
//		System.out.println("student Id: " + tempStudent2.getId());
//		Student tempStudent3 = new Student("test3", "test", "test ");
//		System.out.println("saving student");
//		studentDAO.save(tempStudent3);
//		System.out.println("student Id: " + tempStudent3.getId());
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating the student");
		Student tempStudent = new Student("test", "test", "test ");
		System.out.println("saving student");
		studentDAO.save(tempStudent);
		System.out.println("student Id: " + tempStudent.getId());
	}
}
