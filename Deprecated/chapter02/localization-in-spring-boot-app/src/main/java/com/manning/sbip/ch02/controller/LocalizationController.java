package com.manning.sbip.ch02.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LocalizationController {

    private Log log = LogFactory.getLog(LocalizationController.class);

    private MessageSource messageSource;

    @Autowired
    public LocalizationController(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @GetMapping
    public String message() {
        log.info("Configured locale: "+LocaleContextHolder.getLocale());
        return messageSource.getMessage("hello", null, LocaleContextHolder.getLocale());
    }
}
