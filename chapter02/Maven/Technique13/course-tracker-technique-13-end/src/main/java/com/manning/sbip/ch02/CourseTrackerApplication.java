package com.manning.sbip.ch02;

import com.manning.sbip.ch02.model.User;
import com.manning.sbip.ch02.validation.PasswordRuleValidator;
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
        User user1 = new User("sbip01", "sbip");
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
        Set<ConstraintViolation<User>> violations = validator.validate(user1);
        violations.forEach(courseConstraintViolation -> logger.error("A constraint violation has occurred. Violation details: [{}].", courseConstraintViolation));

        User user2 = new User("sbip01", "Sbip01$4UDfg");
        violations = validator.validate(user2);
        if(violations.isEmpty()) {
            logger.info("Password for user2 adhere to the password policy");
        }

    }
}
