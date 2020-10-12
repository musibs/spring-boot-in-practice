package com.manning.sbip.ch02;

import com.manning.sbip.ch02.banner.CustomizedBanner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CustomizeSpringBootBannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomizeSpringBootBannerApplication.class, args);
        SpringApplication springApplication = new SpringApplication(CustomizeSpringBootBannerApplication.class);
        springApplication.setBanner(new CustomizedBanner());
        springApplication.run(args);
    }

}
