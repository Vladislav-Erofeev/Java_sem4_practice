package com.example.Java_task19.dto;

import com.example.Java_task19.models.Worker;
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
