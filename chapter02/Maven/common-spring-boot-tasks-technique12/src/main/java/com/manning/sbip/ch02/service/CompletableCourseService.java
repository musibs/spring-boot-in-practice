package com.manning.sbip.ch02.service;

import com.manning.sbip.ch02.model.Course;
import com.manning.sbip.ch02.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class CompletableCourseService {

    private CourseRepository courseRepository;

    @Autowired
    public CompletableCourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Async
    public CompletableFuture<Iterable<Course>> findAllByCategoryAsync(String category) {
        return CompletableFuture.completedFuture(courseRepository.findAllByCategory(category));
    }

    @Async
    public CompletableFuture<Iterable<Course>> findAllByNameAsync(String name) throws InterruptedException {
        System.out.println("\nIntentional delay of 5 seconds for demonstration async behavior");
        TimeUnit.SECONDS.sleep(5);
        return CompletableFuture.completedFuture(courseRepository.findAllByName(name));
    }
}
