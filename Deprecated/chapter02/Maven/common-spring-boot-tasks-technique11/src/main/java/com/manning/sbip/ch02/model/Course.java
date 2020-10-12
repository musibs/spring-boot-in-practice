package com.manning.sbip.ch02.model;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "COURSE_DETAILS")
public class Course {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	public Course() {}

	public Course(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Course [" +
				"id=" + id +
				", name='" + name + '\'' +
				", description='" + description + '\'' +
				']';
	}
}
