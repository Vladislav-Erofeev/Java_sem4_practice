package com.example.Java_spring_task18.dto;

import com.example.Java_spring_task18.models.Worker;
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
