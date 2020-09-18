package com.manning.sbip.ch02.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manning.sbip.ch02.model.Course;

import java.util.List;
import java.util.stream.Stream;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    Stream<Course> streamAllByCategory(String category);

    Iterable<Course> findAllByCategory(String category);

    Iterable<Course> findAllByCategoryOrderByName(String category);

    boolean existsByName(String name);

    long countByCategory(String category);

    Iterable<Course> findByNameOrCategory(String name, String category);

    Iterable<Course> findByNameStartsWith(String name);

    Iterable<Course> findAllByName(String name);
}
