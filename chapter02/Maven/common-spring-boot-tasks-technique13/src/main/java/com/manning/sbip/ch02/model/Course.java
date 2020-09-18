package com.manning.sbip.ch02.model;


import javax.persistence.*;

@Entity
@Table(name = "COURSE_DETAILS")
@NamedQuery(name = "Course.findAllByCategory", query = "select c from Course c where c.category=?1")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String category;
	private String description;

	public Course() {}

	public Course(String name, String category, String description) {
		this.name = name;
		this.category = category;
		this.description = description;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Course{" +
				"id=" + id +
				", name='" + name + '\'' +
				", category='" + category + '\'' +
				", description='" + description + '\'' +
				'}';
	}
}
