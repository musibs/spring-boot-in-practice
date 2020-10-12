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

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity(name="courses")
@Table(name="courses")
@Getter
@Setter
@ToString
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	private String description;
	
	@JsonBackReference
	@ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
	private Set<Author> authors = new HashSet<>();
	
	public Course() {}
	
	public Course(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Course(long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}	
}
