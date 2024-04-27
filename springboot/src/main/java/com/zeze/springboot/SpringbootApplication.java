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
			System.out.println("hello");
			createStudent(studentDAO);
		};
	}

	private void createStudent(StudentDAO studentDAO) {
		System.out.println("Creating the student");
		Student tempStudent = new Student("test", "test", "test ");
		System.out.println("saving student");
		studentDAO.save(tempStudent);
		System.out.println("student Id: " + tempStudent.getId());
	}
}
