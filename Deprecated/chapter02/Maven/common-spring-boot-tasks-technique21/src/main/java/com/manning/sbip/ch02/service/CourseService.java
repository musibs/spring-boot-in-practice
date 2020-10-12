package com.manning.sbip.ch02.service;

import com.manning.sbip.ch02.model.Course;

import java.util.Optional;

public interface CourseService {

    Iterable<Course> createCourse(Course course);

    Optional<Course> findCourseById(long courseId);

    Iterable<Course> findAllCourses();

    Iterable<Course> updateCourse(Course course);

    Iterable<Course> deleteCourseById(long courseId);

}
