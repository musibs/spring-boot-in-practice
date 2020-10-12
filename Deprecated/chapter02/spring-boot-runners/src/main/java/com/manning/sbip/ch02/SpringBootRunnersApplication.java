package com.manning.sbip.ch02;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootRunnersApplication /*implements CommandLineRunner */ {

    protected final Log logger = LogFactory.getLog(getClass());

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRunnersApplication.class, args);
    }

    /*@Override
    public void run(String... args) throws Exception {
        logger.info("SpringBootRunnersApplication CommandLineRunner has executed");
    }*/

    /*@Bean
    public CommandLineRunner print() {
         return args -> logger.info("SpringBootRunnersApplication CommandLineRunner executed as a bean definition");
    }*/
}
