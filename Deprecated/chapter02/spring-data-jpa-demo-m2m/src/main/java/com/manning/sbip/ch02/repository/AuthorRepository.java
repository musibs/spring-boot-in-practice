package com.manning.sbip.ch02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manning.sbip.ch02.dto.AuthorCourseDto;
import com.manning.sbip.ch02.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {
	
	@Query("SELECT new com.manning.sbip.ch02.dto.AuthorCourseDto(c.id, c.name, c.description) from courses c, authors_courses ac where c.id=ac.courseId and ac.authorId=?1")
	public List<AuthorCourseDto> getAuthorCourseInfo(long authorId);
}
