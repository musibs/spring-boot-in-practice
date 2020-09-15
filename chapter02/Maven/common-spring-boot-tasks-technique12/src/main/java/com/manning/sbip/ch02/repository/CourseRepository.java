package com.manning.sbip.ch02.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manning.sbip.ch02.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

    public Iterable<Course> findAllByName(String name);

    public Iterable<Course> readAllByName(String name);

    public boolean existsByName(String name);

    public boolean countByCategory(String category);

    public Course findByNameOrCategory(String name, String category);

    public Iterable<Course> findByNameLike(String name);
}
