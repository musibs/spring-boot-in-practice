package com.manning.sbip.ch02.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class ServerInfoRestController {

    @GetMapping
    public String getServerInfo(HttpServletRequest httpServletRequest) {
        return httpServletRequest.getServletContext().getServerInfo();
    }
}
