package com.example.Java_spring_task16.dto;

import com.example.Java_spring_task16.models.Worker;
import jakarta.persistence.Column;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ManufactureDTO {
    private String name;
    private String address;
    private List<Worker> workerList;
}
