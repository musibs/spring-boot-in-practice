package com.manning.sbip.ch02;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class CommonSpringBootTasksApplication implements CommandLineRunner, ApplicationRunner {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(CommonSpringBootTasksApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        logger.info("CommonSpringBootTasksApplication CommandLineRunner has executed");
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        if(!args.containsOption("Spring Boot")) {
            throw new IllegalArgumentException("Expecting option Spring Boot");
        }

        logger.info("Source Args: "+ Arrays.toString(args.getSourceArgs()));
        logger.info("Option names: "+args.getOptionNames());
        logger.info("Non Option names: "+args.getNonOptionArgs());
        logger.info("values provided for option arguments are: "+args.getOptionValues("argument1"));

    }
}