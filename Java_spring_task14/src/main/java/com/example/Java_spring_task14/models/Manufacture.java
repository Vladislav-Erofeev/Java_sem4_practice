package com.example.Java_spring_task14.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
public class Manufacture {
    private int id;
    private String name;
    private String address;

    public Manufacture(int id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }
}
