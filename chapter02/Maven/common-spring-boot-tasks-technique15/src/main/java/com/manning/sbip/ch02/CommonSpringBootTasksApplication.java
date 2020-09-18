package com.manning.sbip.ch02;

import com.manning.sbip.ch02.model.Course;
import com.manning.sbip.ch02.model.QCourse;
import com.manning.sbip.ch02.repository.CourseRepository;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class CommonSpringBootTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonSpringBootTasksApplication.class, args);
    }


    @Bean
    public CommandLineRunner printCourses(CourseRepository courseRepository, EntityManager entityManager) {
        return args -> {

            Course rapidSpringBootCourse = new Course("Rapid Spring Boot Application Development", "Spring", 4, "Spring Boot gives all the power of the Spring Framework without all of the complexity");
            Course springSecurityDslCourse = new Course("Getting Started with Spring Security DSL", "Spring", 2, "Learn Spring Security DSL in easy steps");
            Course springCloudKubernetesCourse = new Course("Getting Started with Spring Cloud Kubernetes", "Spring", 4, "Master Spring Boot application deployment with Kubernetes");
            courseRepository.saveAll(Arrays.asList(rapidSpringBootCourse, springSecurityDslCourse, springCloudKubernetesCourse));

            QCourse course = QCourse.course;

            JPAQuery query = new JPAQuery(entityManager);
            query.from(course).where(course.category.eq("Spring"));
            List<Course> courses1 = query.fetch();

            System.out.println("\nAll Courses with category as Spring:");
            courses1.forEach(System.out::println);

            JPAQuery query2 = new JPAQuery(entityManager);
            query2.from(course).where(course.category.eq("Spring").and(course.rating.gt(3)));
            List<Course> courses2 = query2.fetch();

            System.out.println("\nAll Courses with category as Spring and rating greater than 3:");
            courses2.forEach(System.out::println);

            System.out.println("\nAll Courses in descending sorting order of rating:");
            OrderSpecifier<Integer> descOrderSpecifier = course.rating.desc();
            courseRepository.findAll(descOrderSpecifier).forEach(System.out::println);
        };
    }
}