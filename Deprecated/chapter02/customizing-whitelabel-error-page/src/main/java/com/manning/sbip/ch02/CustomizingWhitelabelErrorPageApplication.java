package com.manning.sbip.ch02;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;

@SpringBootApplication
public class CustomizingWhitelabelErrorPageApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomizingWhitelabelErrorPageApplication.class, args);
    }

}
