package com.example.Java_spring_task15.utils;

import com.example.Java_spring_task15.models.Worker;
import org.springframework.stereotype.Component;

@Component
public class WorkerValidator {
    public boolean validate(Worker worker) {
        if(worker.getFirstName() == null || worker.getMiddleName() == null
        || worker.getLastName() == null)
            return false;
        return true;
    }
}
