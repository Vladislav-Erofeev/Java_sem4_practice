package com.example.Java_spring_task15.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WorkerResponse {
    private String message;

    public WorkerResponse(String message) {
        this.message = message;
    }
}
