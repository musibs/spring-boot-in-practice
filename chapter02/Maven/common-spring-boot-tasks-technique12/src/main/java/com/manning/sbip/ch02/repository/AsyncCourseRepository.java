package com.manning.sbip.ch02.repository;

import com.manning.sbip.ch02.model.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AsyncCourseRepository extends CrudRepository<Course, Long> {

    Iterable<Course> findAllByCategory(String category);
    Iterable<Course> findAllByName(String name);
}
