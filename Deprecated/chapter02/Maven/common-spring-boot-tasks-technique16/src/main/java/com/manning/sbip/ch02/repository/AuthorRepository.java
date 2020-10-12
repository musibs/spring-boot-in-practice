package com.manning.sbip.ch02.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manning.sbip.ch02.dto.AuthorCourseDto;
import com.manning.sbip.ch02.model.Author;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Long> {

    @Query("SELECT new com.manning.sbip.ch02.dto.AuthorCourseDto(c.name, c.rating, c.description, a.name, a.bio) from COURSE c, AUTHOR a, AUTHOR_COURSE ac where c.id=ac.courseId and a.id=ac.authorId and ac.authorId=?1")
    public List<AuthorCourseDto> getAuthorCourseInfo(long authorId);
}
