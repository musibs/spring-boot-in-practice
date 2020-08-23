package com.manning.sbip.ch02.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

@Data
@Entity
public class Conference {
    @Id
    private Long conferenceId;
    private String conferenceName;
    private String conferenceLocation;
    private String conferenceSpeaker;
    private Date conferenceDate;
}
