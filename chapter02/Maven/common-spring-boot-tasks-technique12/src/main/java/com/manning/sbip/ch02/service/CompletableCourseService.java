package com.manning.sbip.ch02.service;

import com.manning.sbip.ch02.model.Course;
import com.manning.sbip.ch02.repository.AsyncCourseRepository;
import com.manning.sbip.ch02.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Service
public class CompletableCourseService {

    private AsyncCourseRepository asyncCourseRepository;

    @Autowired
    public CompletableCourseService(AsyncCourseRepository asyncCourseRepository) {
        this.asyncCourseRepository = asyncCourseRepository;
    }

    @Async
    public CompletableFuture<Iterable<Course>> findAllByCategoryAsync(String category) {
        return CompletableFuture.completedFuture(asyncCourseRepository.findAllByCategory(category));
    }

    @Async
    public CompletableFuture<Iterable<Course>> findAllByNameAsync(String name) throws InterruptedException {
        System.out.println("Intentional delay of 10 seconds for demonstration async behavior");
        TimeUnit.SECONDS.sleep(10);
        return CompletableFuture.completedFuture(asyncCourseRepository.findAllByName(name));
    }
}
