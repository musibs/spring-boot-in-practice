package com.manning.sbip.ch02;

import com.manning.sbip.ch02.model.Course;
import com.manning.sbip.ch02.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.swing.text.html.Option;
import java.util.Arrays;
import java.util.Optional;

@SpringBootApplication
public class CommonSpringBootTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonSpringBootTasksApplication.class, args);
    }

    @Bean
    public CommandLineRunner printCourses(CourseRepository courseRepository) {
        return args -> {

            Course rapidSpringBootCourse = new Course("Rapid Spring Boot Application Development", "Spring Boot gives all the power of the Spring Framework without all of the complexity");
            Course springSecurityDslCourse = new Course("Getting Started with Spring Security DSL", "Learn Spring Security DSL in easy steps");
            Course springCloudKubernetesCourse = new Course("Getting Started with Spring Cloud Kubernetes", "Master Spring Boot application deployment with Kubernetes");

            //"Create a Single course");
            courseRepository.save(rapidSpringBootCourse);

            //System.out.println("Create a list of courses");
            courseRepository.saveAll(Arrays.asList(springSecurityDslCourse, springCloudKubernetesCourse));

            System.out.println("Find the course with course Id 1:");
            Optional<Course> optionalCourse = courseRepository.findById(Long.valueOf(1));
            optionalCourse.ifPresent(System.out::println);
            //System.out.println("Delete a specific course");
            courseRepository.delete(springCloudKubernetesCourse);

            System.out.println("Find all available courses:");
            Iterable<Course> courses = courseRepository.findAll();
            for(Course course : courses) {
                System.out.println("\t "+course.getId()+") "+course);
            }


        };
    }
}
