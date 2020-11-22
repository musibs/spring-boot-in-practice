package com.manning.sbip.ch03;

import com.manning.sbip.ch03.model.Course;
import com.manning.sbip.ch03.model.CourseId;
import com.manning.sbip.ch03.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class CourseTrackerSpringBootApplicationTests {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void givenCreateCourseWhenLoadTheCourseThenExpectSameCourse() {
        CourseId courseId = new CourseId(1, "Rapid Spring Boot Application Development");
        Course course = new Course(courseId, "Spring", 4, "'Spring Boot gives all the power of the Spring Framework without all of the complexities");
        courseRepository.save(course);
        assertThat(courseRepository.findById(courseId).get()).isEqualTo(course);
    }
}
