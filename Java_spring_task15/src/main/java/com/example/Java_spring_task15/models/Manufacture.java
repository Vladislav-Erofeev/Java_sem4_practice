package com.example.Java_spring_task15.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Manufacture {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "address")
    private String address;
}
