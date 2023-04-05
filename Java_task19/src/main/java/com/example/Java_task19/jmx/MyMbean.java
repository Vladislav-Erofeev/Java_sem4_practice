package com.example.Java_task19.jmx;

import com.example.Java_task19.services.ScheduledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@ManagedResource
public class MyMbean {

    private final ScheduledService scheduledService;

    @Autowired
    public MyMbean(ScheduledService scheduledService) {
        this.scheduledService = scheduledService;
    }

    @ManagedOperation(description = "Run scheduled task")
    public void run() throws IOException {
        scheduledService.scheduledTask();
    }
}
