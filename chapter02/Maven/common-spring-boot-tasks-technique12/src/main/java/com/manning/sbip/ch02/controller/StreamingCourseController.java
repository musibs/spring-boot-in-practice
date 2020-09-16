package com.manning.sbip.ch02.controller;

import com.manning.sbip.ch02.model.Course;
import com.manning.sbip.ch02.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.stream.Stream;

@RestController
public class StreamingCourseController {

    private CourseRepository courseRepository;

    @Autowired
    public StreamingCourseController(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Transactional
    @GetMapping("/courses")
    public String getAllCourses() {
        System.out.println("\nFind all courses as stream where category as `JavaScript`:");
        try(Stream<Course> javaScriptCourses = courseRepository.streamAllByCategory("JavaScript")){
            javaScriptCourses.forEach(System.out::println);
        }
        return "Check application console!";
    }
}
