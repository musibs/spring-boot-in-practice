package com.manning.sbip.ch02.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manning.sbip.ch02.model.Course;

@Repository
public interface CourseRepository extends CrudRepository<Course, Long> {

}
