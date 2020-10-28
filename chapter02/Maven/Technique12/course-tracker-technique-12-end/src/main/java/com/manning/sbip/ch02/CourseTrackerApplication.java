package com.manning.sbip.ch02;

import com.manning.sbip.ch02.model.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

@SpringBootApplication
public class CourseTrackerApplication implements CommandLineRunner {

    private static Logger logger = LoggerFactory.getLogger(CourseTrackerApplication.class);
    public static void main(String[] args) {
        SpringApplication.run(CourseTrackerApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        try {
            Course course = new Course();
            course.setId(1L);
            course.setRating(0);

            Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
            Set<ConstraintViolation<Course>> violations = validator.validate(course);
            violations.forEach(
                    courseConstraintViolation -> {
                        logger.error("A violation has occured. Violation details: [{}].", courseConstraintViolation);
                    }
            );

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
