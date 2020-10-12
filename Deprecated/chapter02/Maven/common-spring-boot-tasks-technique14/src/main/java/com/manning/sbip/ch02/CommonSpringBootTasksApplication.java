package com.manning.sbip.ch02;

import com.manning.sbip.ch02.model.Course;
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
    public CommandLineRunner printCourses(CourseRepository courseRepository) {
        return args -> {

            Course rapidSpringBootCourse = new Course("Rapid Spring Boot Application Development", "Spring", 4, "Spring Boot gives all the power of the Spring Framework without all of the complexity");
            Course springSecurityDslCourse = new Course("Getting Started with Spring Security DSL", "Spring", 2, "Learn Spring Security DSL in easy steps");
            Course springCloudKubernetesCourse = new Course("Getting Started with Spring Cloud Kubernetes", "Spring", 4, "Master Spring Boot application deployment with Kubernetes");
            courseRepository.saveAll(Arrays.asList(rapidSpringBootCourse, springSecurityDslCourse, springCloudKubernetesCourse));

            System.out.println("\nList of courses that belongs to Spring category:");
            courseRepository.findAllByCategory("Spring").forEach(System.out::println);

            System.out.println("\nList of courses that belongs to Spring category and has a rating greater than 3:");
            courseRepository.findAllByCategoryAndRatingGreaterThan("Spring", 3).forEach(System.out::println);

            System.out.println("\nUpdating the rating of `Getting Started with Spring Security DSL` course to 3");
            System.out.println("Successfully updated "+ courseRepository.updateCourseRatingByName(3, "Getting Started with Spring Security DSL") +" record.");

            System.out.println("\nUpdated course details:");
            courseRepository.findAll().forEach(System.out::println);
        };
    }
}