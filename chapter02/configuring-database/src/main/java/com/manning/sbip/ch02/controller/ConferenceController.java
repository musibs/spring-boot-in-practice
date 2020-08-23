package com.manning.sbip.ch02.controller;

import com.manning.sbip.ch02.model.Conference;
import com.manning.sbip.ch02.repository.ConferenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConferenceController {

    private ConferenceRepository conferenceRepository;

    @Autowired
    public ConferenceController(ConferenceRepository conferenceRepository) {
        this.conferenceRepository = conferenceRepository;
    }

    @GetMapping
    public Iterable<Conference> getAllConferences() {
        return conferenceRepository.findAll();
    }
}
