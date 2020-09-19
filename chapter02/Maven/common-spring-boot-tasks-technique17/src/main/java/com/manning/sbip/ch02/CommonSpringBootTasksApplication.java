package com.manning.sbip.ch02;

import com.manning.sbip.ch02.model.Author;
import com.manning.sbip.ch02.model.Course;
import com.manning.sbip.ch02.repository.AuthorRepository;
import com.manning.sbip.ch02.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;

@SpringBootApplication
public class CommonSpringBootTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonSpringBootTasksApplication.class, args);
    }


    @Bean
    public CommandLineRunner printCourses(CourseRepository courseRepository, AuthorRepository authorRepository) {
        return args -> {

            Course rapidSpringBootCourse = new Course("Rapid Spring Boot Application Development", "Spring", 4, "Spring Boot gives all the power of the Spring Framework without all of the complexity");
            Course springSecurityDslCourse = new Course("Getting Started with Spring Security DSL", "Spring", 2, "Learn Spring Security DSL in easy steps");
            Course springCloudKubernetesCourse = new Course("Getting Started with Spring Cloud Kubernetes", "Spring", 4, "Master Spring Boot application deployment with Kubernetes");
            courseRepository.saveAll(Arrays.asList(rapidSpringBootCourse, springSecurityDslCourse, springCloudKubernetesCourse));

            Author author1 = new Author("John Doe", "Author of several Spring Boot courses");
            Author author2 = new Author("Steve Muller", "Author of several popular Spring and Pyhton courses");
            authorRepository.saveAll(Arrays.asList(author1, author2));

            author1.getCourses().addAll(Arrays.asList(rapidSpringBootCourse, springSecurityDslCourse));
            author2.getCourses().addAll(Arrays.asList(rapidSpringBootCourse, springSecurityDslCourse, springCloudKubernetesCourse));
            authorRepository.saveAll(Arrays.asList(author1, author2));

            System.out.println("\nThe Course and Author information for Author ID 2:");
            authorRepository.getAuthorCourseInfo(2).forEach(System.out::println);

        };
    }
}