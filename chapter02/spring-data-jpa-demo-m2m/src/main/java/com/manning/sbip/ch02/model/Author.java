package com.manning.sbip.ch02.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity(name = "authors")
@Table(name="authors")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Author {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String name;
	private String bio;
	
	//@JsonManagedReference
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
	@JoinTable(name = "authors_courses", 
				joinColumns = {@JoinColumn(name="author_id", referencedColumnName = "id", nullable = false, updatable = false)},
				inverseJoinColumns = {@JoinColumn(name="course_id", referencedColumnName = "id", nullable = false, updatable = false)}
	)
	private Set<Course> courses = new HashSet<>();
	
	public Author(String name, String bio) {
		this.name = name;
		this.bio = bio;
	}
}
