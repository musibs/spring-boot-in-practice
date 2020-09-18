package com.manning.sbip.ch02.controller;

import com.manning.sbip.ch02.model.Course;
import com.manning.sbip.ch02.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String getAllCourses(@RequestParam("category") String category) {
        if(!("Spring".equalsIgnoreCase(category) || "Python".equalsIgnoreCase(category) || "JavaScript".equalsIgnoreCase(category))) {
            return "Invalid Course Category. Must be either Spring, Python, or JavaScript";
        }
        System.out.println("\nFind all courses as Stream where category as `"+category+"`:");
        try(Stream<Course> courses = courseRepository.streamAllByCategory(category)){
            courses.forEach(System.out::println);
        }
        return "Check application console!";
    }
}
