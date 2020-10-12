package com.manning.sbip.ch02.repository;

import com.manning.sbip.ch02.model.Course;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomizedCourseRepository extends BaseRepository<Course, Long> {
}
