package com.example.Java_spring_task16.dto;

import com.example.Java_spring_task16.models.Manufacture;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class WorkerDTO {
    private String firstName;
    private String middleName;
    private String lastName;
    private Manufacture manufacture;
}
