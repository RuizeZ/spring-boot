package com.zeze.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
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
}
