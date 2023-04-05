package com.example.Java_spring_task14.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Worker {
    private int id;
    private String firstName;
    private String middleName;
    private String lastName;

    public Worker(int id, String firstName, String middleName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
    }
}
