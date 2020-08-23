package com.manning.sbip.ch02.commandline;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/*@Order(1)
@Component*/
public class MyCommandLineRunner implements CommandLineRunner {

    protected final Log logger = LogFactory.getLog(getClass());

    @Override
    public void run(String... args) throws Exception {
        logger.info("MyCommandLineRunner executed as a Spring Component");
    }
}
