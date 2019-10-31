package com.paweloot.learning.fullstackspringbootreact;

import java.util.UUID;

public class Course {
    private UUID id;
    private String username;
    private String description;

    public Course() {

    }

    public Course(String username, String description) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.description = description;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
