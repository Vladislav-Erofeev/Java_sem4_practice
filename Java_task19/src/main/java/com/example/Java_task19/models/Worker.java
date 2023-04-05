package com.example.Java_task19.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@Table(name = "worker")
public class Worker {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "middle_name")
    private String middleName;
    @Column(name = "last_name")
    private String lastName;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "manufacture_id", referencedColumnName = "id")
    private Manufacture manufacture;

}
