package com.manning.sbip.ch02.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@NotBlank(message = "Course name should not be empty")
	private String name;
	@NotBlank(message = "Course description should not be empty")
	private String description;

	public Course(String name, String description) {
		this.name = name;
		this.description = description;
	}
}
