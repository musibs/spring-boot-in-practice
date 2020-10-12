package com.manning.sbip.ch02.service;

import com.manning.sbip.ch02.model.Course;
import com.manning.sbip.ch02.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DefaultCourseService implements CourseService {

    private CourseRepository courseRepository;

    public DefaultCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Iterable<Course> createCourse(Course course) {
        courseRepository.save(course);
        return findAllCourses();
    }

    @Override
    public Optional<Course> findCourseById(long courseId) {
        return courseRepository.findById(courseId);
    }

    @Override
    public Iterable<Course> findAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Iterable<Course> updateCourse(Course course) {
        return createCourse(course);
    }

    @Override
    public Iterable<Course> deleteCourseById(long courseId) {
        courseRepository.deleteById(courseId);
        return findAllCourses();
    }
}
