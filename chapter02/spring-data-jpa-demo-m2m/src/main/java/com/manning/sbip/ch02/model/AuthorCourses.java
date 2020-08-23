package com.manning.sbip.ch02.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity(name = "authors_courses")
@Table(name = "authors_courses")
@Data
public class AuthorCourses {

	@Id
	@Column(name = "author_id")
	private long authorId;
	@Column(name = "course_id")
	private long courseId;
}
