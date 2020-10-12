package com.manning.sbip.ch02;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.manning.sbip.ch02.model.Author;
import com.manning.sbip.ch02.model.Course;
import com.manning.sbip.ch02.repository.AuthorRepository;
import com.manning.sbip.ch02.repository.CourseRepository;

@SpringBootApplication
public class SpringDataJpaDemoM2mApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaDemoM2mApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(AuthorRepository authorRepository, CourseRepository courseRepository) {
		
		return args -> {
			
			Course course1 = new Course("Practical Spring Boot", "This course explains Spring Boot with Practical Recipes");
			Course course2 = new Course("Python for Beginners", "This course explains Python for beginners");
			Course course3 = new Course("Spring Boot for Beginners", "This course explains Spring Boot for beginners");
			Course course4 = new Course("Practical Python", "This course explains Python with Practical Recipes");
			
			courseRepository.saveAll(Arrays.asList(course1, course2, course3, course4));
			
			Author author1 = new Author("John Doe", "Author of several Spring Boot courses");
			Author author2 = new Author("Steve Muller", "Author of several popular Spring and Pyhton courses");
			authorRepository.saveAll(Arrays.asList(author1, author2));
			
			author1.getCourses().addAll(Arrays.asList(course1, course3));
			author2.getCourses().addAll(Arrays.asList(course1, course2, course4));
			authorRepository.saveAll(Arrays.asList(author1, author2));
			
		};
	}
}
