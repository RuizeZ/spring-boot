package com.zeze.springboot;

import com.zeze.crud.dao.StudentDAO;
import com.zeze.crud.entity.Student;
import com.zeze.springboot.dao.AppDAO;
import com.zeze.springboot.entity.Course;
import com.zeze.springboot.entity.Instructor;
import com.zeze.springboot.entity.InstructorDetail;
import com.zeze.springboot.entity.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;

import static org.springframework.security.config.Customizer.withDefaults;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zeze.crud", "com.zeze.springboot"})
@EntityScan(basePackages = {"com.zeze.crud.entity", "com.zeze.springboot"})
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
	@EnableWebSecurity
	public class SecurityConfig {

		@Bean
		public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
			http
					.authorizeHttpRequests((requests) -> requests
							.requestMatchers("/**").permitAll() // Public endpoint
							.anyRequest().authenticated() // All other endpoints require authentication
					).formLogin(withDefaults()) // Configure form login
					.httpBasic(withDefaults());  // Configure HTTP Basic authentication

			return http.build();
		}
	}
	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO){
		return runner -> {
//			createInstructor(appDAO);
//			findInstructor(appDAO);
//			deleteInstructorById(appDAO);
//			findInstructorDetail(appDAO);
//			deleteInstructorDetail(appDAO);
//			createInstructorWithCourses(appDAO);
			findInstructorWithCourses(appDAO);
//			findCourseForInstructor(appDAO);
//			findInstructorWithCoursesJoinFetch(appDAO);
//			updateInstructor(appDAO);
//			updateCourse(appDAO);
//			deleteCourseById(appDAO);
//			createCourseAndReviews(appDAO);
//			getCourseAndReviews(appDAO);
//			deleteCourseAndReviews(appDAO);
		};
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		System.out.println("Deleting");
		appDAO.deleteCourseById(theId);
	}

	private void getCourseAndReviews(AppDAO appDAO) {
		int theId = 10;
		Course tempCourse = appDAO.findCourseAndReviewsByCourseId(theId);
		System.out.println(tempCourse);
		System.out.println(tempCourse.getReviews());
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course tempCourse = new Course("C++");
		tempCourse.addReview(new Review("Bad"));
		tempCourse.addReview(new Review("Good"));
		tempCourse.addReview(new Review("hahaha"));
		tempCourse.addReview(new Review("you sucks"));
		appDAO.save(tempCourse);
	}

	private void deleteCourseById(AppDAO appDAO) {
		int theId = 10;
		appDAO.deleteCourseById(theId);
	}

	private void updateCourse(AppDAO appDAO) {
		int theId = 10;
		Course courseById = appDAO.findCourseById(theId);
		courseById.setTitle("ECON101");
		appDAO.updateCourse(courseById);
		System.out.println("Done");
	}

	private void updateInstructor(AppDAO appDAO) {
		int theId = 2;
		Instructor instructor = appDAO.findInstructorById(theId);
		instructor.setFirstName("Steve");
		appDAO.update(instructor);
		System.out.println("Done");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding id: " + theId);
		Instructor instructor = appDAO.findInstructorByIdJoinFetch(theId);
		System.out.println(instructor);
		System.out.println("Done");

	}

	private void findCourseForInstructor(AppDAO appDAO) {
		int theId = 2;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("Finding courses");
		List<Course> courses = appDAO.findCoursesByInstructorId(theId);
		tempInstructor.setCourses(courses);
		System.out.println("the courses: " + tempInstructor.getCourses());
		System.out.println("Done");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);
		Instructor tempInstructor = appDAO.findInstructorById(theId);
		System.out.println("tempInstructor: " + tempInstructor);
		System.out.println("the courses: " + tempInstructor.getCourses());
		System.out.println("Done");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor tempInstructor =
				new Instructor("Ruize", "Zhang", "zeze.zhang@gmail.com");
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("www.google.com", "gamer");
		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Course tempCourse1 = new Course("Java");
		Course tempCourse2 = new Course("Python");
		Course tempCourse3 = new Course("Go");
		tempInstructor.add(tempCourse1);
		tempInstructor.add(tempCourse2);
		tempInstructor.add(tempCourse3);

		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done");
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int theId = 6;
		System.out.println("Delete InstructorDetail ID: " + theId);
		appDAO.deleteInstructorDetailById(theId);
		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int theId = 2;
		InstructorDetail tempInstructorDetail = appDAO.findInstructorDetailById(theId);
		System.out.println("tempInstructorDetail: "+ tempInstructorDetail.getHobby());
		System.out.println("tempInstructor: "+ tempInstructorDetail.getInstructor());
		System.out.println("DONE");
	}

	private void deleteInstructorById(AppDAO appDAO) {
		int theId = 2;
		appDAO.deleteInstructorById(theId);
		System.out.println("done");
	}

	private void findInstructor(AppDAO appDAO) {
		int theId = 1;
		System.out.println("Finding instructor id: " + theId);
		Instructor thempInstructor = appDAO.findInstructorById(theId);
		System.out.println("thempInstructor: " + thempInstructor);
		System.out.println("detail: " + thempInstructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
//		Instructor tempInstructor =
//				new Instructor("Ruize", "Zhang", "ruize.zhang@gmail.com");
//		InstructorDetail tempInstructorDetail =
//				new InstructorDetail("www.youtube.com", "Coding");
//		tempInstructor.setInstructorDetail(tempInstructorDetail);

		Instructor tempInstructor =
				new Instructor("Zeze", "Zhang", "zeze.zhang@gmail.com");
		InstructorDetail tempInstructorDetail =
				new InstructorDetail("www.youtube.com", "soccer");
		tempInstructor.setInstructorDetail(tempInstructorDetail);


		System.out.println("Saving instructor: " + tempInstructor);
		appDAO.save(tempInstructor);
		System.out.println("Done");
	}

	private void deleteAll(StudentDAO studentDAO) {
		System.out.println(studentDAO.deleteAll());
	}

	private void delete(StudentDAO studentDAO) {
		studentDAO.delete(1);
	}

//	private void update(StudentDAO studentDAO) {
//		Student student = studentDAO.findById(1);
//		student.setLastName("zeze");
//		studentDAO.update(student);
//		System.out.println(studentDAO.findById(1));
//	}
//
//	private void queryForStudentsByLastName(StudentDAO studentDAO) {
//		List<Student> students = studentDAO.findByLastName("zhang");
//		for (Student student :
//				students) {
//			System.out.println(student);
//		}
//	}
//
//	private void queryForStudents(StudentDAO studentDAO) {
//		List<Student> theStudents = studentDAO.findAll();
//		for (Student student :
//				theStudents) {
//			System.out.println(student);
//		}
//	}
//
//	private void readStudent(StudentDAO studentDAO) {
//		System.out.println("Creating the student");
//		Student tempStudent = new Student("test", "test", "test ");
//		System.out.println("saving student");
//		studentDAO.save(tempStudent);
//		System.out.println("student Id: " + tempStudent.getId());
//		System.out.println(studentDAO.findById(tempStudent.getId()));
//	}
//
//	private void createMultipleStudents(StudentDAO studentDAO) {
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
//	}
//
//	private void createStudent(StudentDAO studentDAO) {
//		System.out.println("Creating the student");
//		Student tempStudent = new Student("test", "test", "test ");
//		System.out.println("saving student");
//		studentDAO.save(tempStudent);
//		System.out.println("student Id: " + tempStudent.getId());
//	}
}
