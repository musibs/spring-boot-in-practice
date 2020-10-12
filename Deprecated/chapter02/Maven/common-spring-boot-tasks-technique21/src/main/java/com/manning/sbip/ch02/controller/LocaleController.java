package com.manning.sbip.ch02.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

@Controller
public class LocaleController {

    private LocaleResolver localeResolver;

    @Autowired
    public LocaleController(LocaleResolver localeResolver) {
        this.localeResolver = localeResolver;
    }

    @GetMapping("/changeLocale")
    public String changeLocale(HttpServletRequest request, @Nullable HttpServletResponse response) {
        switch(localeResolver.resolveLocale(request).getCountry()){
            case "US" :
                localeResolver.setLocale(request, response, Locale.ITALY);
                break;
            case "IT" :
                localeResolver.setLocale(request, response, Locale.US);
                break;
        }
        return "redirect:/index";
    }
}
