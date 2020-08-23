package com.manning.sbip.ch02.controller;

import com.manning.sbip.ch02.model.Conference;
import com.manning.sbip.ch02.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@Controller
public class ConferenceController {

    private ConferenceRepository conferenceRepository;

    @Autowired
    public ConferenceController(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    @GetMapping
    public String getAllConferences(Model model) {
        model.addAttribute("conferences", conferenceRepository.findAll());
        return "conferences";
    }
}
