package com.manning.sbip.ch02;

import com.manning.sbip.ch02.model.Author;
import com.manning.sbip.ch02.model.Course;
import com.manning.sbip.ch02.repository.AuthorRepository;
import com.manning.sbip.ch02.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CommonSpringBootTasksApplicationTests {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @Test
    void contextLoads() {
    }

    @Test
    public void whenCountAllCoursesThenExpectFiveCourses() {
        Course rapidSpringBootCourse = new Course("Rapid Spring Boot Application Development", "Spring", 4,"Spring Boot gives all the power of the Spring Framework without all of the complexity");
        Course springSecurityDslCourse = new Course("Getting Started with Spring Security DSL", "Spring", 5, "Learn Spring Security DSL in easy steps");
        Course springCloudKubernetesCourse = new Course("Getting Started with Spring Cloud Kubernetes", "Spring", 3, "Master Spring Boot application deployment with Kubernetes");
        courseRepository.saveAll(Arrays.asList(rapidSpringBootCourse, springSecurityDslCourse, springCloudKubernetesCourse));

        Author author1 = new Author("John Doe", "Author of several Spring Boot courses");
        Author author2 = new Author("Steve Muller", "Author of several popular Spring and Python courses");

        author1.getCourses().addAll(Arrays.asList(rapidSpringBootCourse, springSecurityDslCourse));
        author2.getCourses().addAll(Arrays.asList(rapidSpringBootCourse, springSecurityDslCourse, springCloudKubernetesCourse));

        authorRepository.saveAll(Arrays.asList(author1, author2));
        assertThat(authorRepository.getAuthorCourseInfo(2).size()).isEqualTo(3);
    }

}
