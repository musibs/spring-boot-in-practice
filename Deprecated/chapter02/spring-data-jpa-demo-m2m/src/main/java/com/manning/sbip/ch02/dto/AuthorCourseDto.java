package com.manning.sbip.ch02.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class AuthorCourseDto {

	private long id;
	private String name;
	private String description;
}
