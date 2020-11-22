package com.manning.sbip.ch03.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "COURSES")
public class Course {

    @EmbeddedId
    private CourseId courseId;

    @Column(name = "CATEGORY")
    private String category;

    @Column(name = "RATING")
    private int rating;

    @Column(name = "DESCRIPTION")
    private String description;

    public Course() {}

    public Course(CourseId courseId, String category, int rating, String description) {
        this.courseId = courseId;
        this.category = category;
        this.rating = rating;
        this.description = description;
    }

    public CourseId getCourseId() {
        return courseId;
    }

    public void setCourseId(CourseId courseId) {
        this.courseId = courseId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course)) return false;
        Course course = (Course) o;
        return rating == course.rating &&
                Objects.equals(courseId, course.courseId) &&
                Objects.equals(category, course.category) &&
                Objects.equals(description, course.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseId, category, rating, description);
    }
}

