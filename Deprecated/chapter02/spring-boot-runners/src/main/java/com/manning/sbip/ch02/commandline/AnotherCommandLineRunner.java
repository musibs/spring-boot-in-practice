package com.manning.sbip.ch02.commandline;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*@Order(2)
@Component*/
public class AnotherCommandLineRunner implements CommandLineRunner {

    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public void run(String... args) throws Exception {
        logger.info("AnotherCommandLineRunner executed as a Spring Component");
    }
}
