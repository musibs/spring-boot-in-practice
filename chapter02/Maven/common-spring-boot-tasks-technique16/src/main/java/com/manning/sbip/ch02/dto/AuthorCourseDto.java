package com.manning.sbip.ch02.dto;

public class AuthorCourseDto {

    private String courseName;
    private int courseRating;
    private String courseDescription;
    private String authorName;
    private String authorBio;

    public AuthorCourseDto(String courseName, int courseRating, String courseDescription, String authorName, String authorBio) {
        this.courseName = courseName;
        this.courseRating = courseRating;
        this.courseDescription = courseDescription;
        this.authorName = authorName;
        this.authorBio = authorBio;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getCourseRating() {
        return courseRating;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorBio() {
        return authorBio;
    }

    @Override
    public String toString() {
        return "AuthorCourseDto{" +
                "courseName='" + courseName + '\'' +
                ", courseRating=" + courseRating +
                ", courseDescription='" + courseDescription + '\'' +
                ", authorName='" + authorName + '\'' +
                ", authorBio='" + authorBio + '\'' +
                '}';
    }
}
