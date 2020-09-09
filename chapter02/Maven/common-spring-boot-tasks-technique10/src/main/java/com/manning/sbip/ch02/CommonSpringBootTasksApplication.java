package com.manning.sbip.ch02;

import com.manning.sbip.ch02.repository.CourseRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CommonSpringBootTasksApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonSpringBootTasksApplication.class, args);
    }

    @Bean
    public CommandLineRunner printCourses(CourseRepository courseRepository) {
        return args -> {
            System.out.println("============= Course Details =================");
            courseRepository.findAll().forEach(System.out::println);
        };
    }
}
