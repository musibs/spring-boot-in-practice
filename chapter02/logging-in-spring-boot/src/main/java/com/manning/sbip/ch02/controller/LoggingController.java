package com.manning.sbip.ch02.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoggingController {

    Logger logger = LoggerFactory.getLogger(LoggingController.class);

    @GetMapping
    public String index() {
        logger.trace("Logging with level TRACE");
        logger.debug("Logging with level DEBUG");
        logger.info("Logging with level INFO");
        logger.warn("Logging with level WARN");
        logger.error("Logging with level ERROR");
        return "Logging with Spring Boot";
    }
}
