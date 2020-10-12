package com.manning.sbip.ch02.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@Controller
public class DefaultErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return "/error";
    }

    //@RequestMapping("/error")
    public String handleError(HttpServletRequest httpServletRequest) {
        Object status = httpServletRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status != null) {
            int statusCode = Integer.parseInt(status.toString());
            if(statusCode == HttpStatus.NOT_FOUND.value()) {
                return "404";
            }
            else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                return "500";
            }
        }
        return "error";
    }
}
