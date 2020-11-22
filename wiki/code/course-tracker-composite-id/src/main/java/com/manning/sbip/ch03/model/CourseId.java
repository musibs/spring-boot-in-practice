package com.manning.sbip.ch03.model;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class CourseId implements Serializable {

    @Column(name = "ID")
    private long id;

    @Column(name = "NAME")
    private String name;

    public CourseId() {
    }

    public CourseId(long id, String name) {
        this.id = id;
        this.name = name;
    }
}
