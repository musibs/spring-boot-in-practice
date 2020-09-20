package com.manning.sbip.ch02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@SpringBootApplication
public class CommonSpringBootTasksApplication {

    Logger logger = LoggerFactory.getLogger(CommonSpringBootTasksApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(CommonSpringBootTasksApplication.class, args);
    }

    @GetMapping
    public String printServerInfo(@Valid HttpServletRequest httpServletRequest) {
        return "Server details: "+httpServletRequest.getServletContext().getServerInfo();
    }

}