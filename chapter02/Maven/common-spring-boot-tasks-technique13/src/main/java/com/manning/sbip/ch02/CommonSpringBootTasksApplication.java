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

            Course rapidSpringBootCourse = new Course("Rapid Spring Boot Application Development", "Spring", "Spring Boot gives all the power of the Spring Framework without all of the complexity");
            Course springSecurityDslCourse = new Course("Getting Started with Spring Security DSL", "Spring", "Learn Spring Security DSL in easy steps");
            Course springCloudKubernetesCourse = new Course("Getting Started with Spring Cloud Kubernetes", "Spring", "Master Spring Boot application deployment with Kubernetes");
            Course rapidPythonCourse = new Course("Getting Started with Python", "Python", "Learn Python concepts in easy steps");
            Course gameDevelopmentWithPython = new Course("Game Development with Python", "Python", "Learn Python by developing 10 wonderful games");
            Course javaScriptForAll = new Course("JavaScript for All", "JavaScript", "Learn basic JavaScript syntax that can apply to anywhere");
            Course javaScriptCompleteGuide = new Course("JavaScript Complete Guide", "JavaScript", "Master JavaScript with Core Concepts and Web Development");

            //System.out.println("Create a list of courses");
            courseRepository.saveAll(Arrays.asList(rapidSpringBootCourse, springSecurityDslCourse, springCloudKubernetesCourse, rapidPythonCourse, gameDevelopmentWithPython, javaScriptForAll, javaScriptCompleteGuide));
            System.out.println("\nFind all courses with category as `Spring`:");
            System.out.println("===========================================");
            Iterable<Course> courses = courseRepository.findAllByCategory("Spring");
            for (Course course : courses) {
                System.out.println("\t " + course.getId() + ") " + course);
            }
            System.out.println("\nFind all courses with category as `Spring` And order by course name:");
            System.out.println("====================================================================");
            for (Course course : courseRepository.findAllByCategoryOrderByName("Spring")) {
                System.out.println("\t " + course.getId() + ") " + course);
            }

            String course1 = "JavaScript for All";
            String course2 = "Mastering JavaScript";
            System.out.println("\nCourse with name `" + course1 + "` exists? " + courseRepository.existsByName(course1));
            System.out.println("Course with name `" + course2 + "` exists? " + courseRepository.existsByName(course2));

            System.out.println("\nTotal number of courses with category Python: " + courseRepository.countByCategory("Python"));

            System.out.println("\nFind courses where course name is `JavaScript for All` or category is `JavaScript`");
            System.out.println("==================================================================================");
            for (Course course : courseRepository.findByNameOrCategory("JavaScript for All", "JavaScript")) {
                System.out.println("\t " + course.getId() + ") " + course);
            }

            System.out.println("\nFind courses where course name starts with `Getting Started`");
            System.out.println("==================================================================================");
            for (Course course : courseRepository.findByNameStartsWith("Getting Started")) {
                System.out.println("\t " + course.getId() + ") " + course);
            }
        };
    }
}