package com.manning.sbip.ch02.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.manning.sbip.ch02.dto.AuthorCourseDto;
import com.manning.sbip.ch02.model.Course;
import com.manning.sbip.ch02.repository.AuthorRepository;
import com.manning.sbip.ch02.repository.CourseRepository;

@RestController
public class CourseController {

	@Autowired
	public AuthorRepository authorRepository;
	
	@Autowired
	public CourseRepository courseRepository;
	
	@GetMapping("/author")
	public List<AuthorCourseDto> getCouses(@RequestParam("authorId") long authorId) {
		return authorRepository.getAuthorCourseInfo(authorId);
	}
	
	@GetMapping("/course")
	public List<Course> getCousesByCourseName(@RequestParam("name") String name) {
		return courseRepository.findByNameContaining(name);
	}
	
}
