package com.manning.sbip.ch02.banner;

import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

public class CustomizedBanner implements Banner {

    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        System.out.println(sourceClass.getName());
        out.println("  _____                  _                     ____                    _       _____             _____                          _     _               \n" +
                "  / ____|                (_)                   |  _ \\                  | |     |_   _|           |  __ \\                        | |   (_)              \n" +
                " | (___    _ __    _ __   _   _ __     __ _    | |_) |   ___     ___   | |_      | |    _ __     | |__) |  _ __    __ _    ___  | |_   _    ___    ___ \n" +
                "  \\___ \\  | '_ \\  | '__| | | | '_ \\   / _` |   |  _ <   / _ \\   / _ \\  | __|     | |   | '_ \\    |  ___/  | '__|  / _` |  / __| | __| | |  / __|  / _ \\\n" +
                "  ____) | | |_) | | |    | | | | | | | (_| |   | |_) | | (_) | | (_) | | |_     _| |_  | | | |   | |      | |    | (_| | | (__  | |_  | | | (__  |  __/\n" +
                " |_____/  | .__/  |_|    |_| |_| |_|  \\__, |   |____/   \\___/   \\___/   \\__|   |_____| |_| |_|   |_|      |_|     \\__,_|  \\___|  \\__| |_|  \\___|  \\___|\n" +
                "          | |                          __/ |                                                                                                           \n" +
                "          |_|                         |___/                                                                                                            \n" +
                " :: Manning Publication ::        "+"("+environment.getProperty("book.edition")+")");
    }
}
