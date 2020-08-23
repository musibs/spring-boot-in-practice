package com.manning.sbip.ch02.application;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.StringJoiner;

@Component
public class MyApplicationRunner implements ApplicationRunner {

    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public void run(ApplicationArguments args) throws Exception {

        if(!args.containsOption("Spring Boot")) {
            throw new IllegalArgumentException("Expecting option Spring Boot");
        }

        logger.info("Source Args: "+Arrays.toString(args.getSourceArgs()));
        logger.info("Option names: "+args.getOptionNames());
        logger.info("Non Option names: "+args.getNonOptionArgs());
        logger.info("values provided for option argument1s are: "+args.getOptionValues("argument1"));
    }
}
