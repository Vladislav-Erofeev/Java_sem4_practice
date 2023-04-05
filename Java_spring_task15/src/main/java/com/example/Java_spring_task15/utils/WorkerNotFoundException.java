package com.example.Java_spring_task15.utils;

public class WorkerNotFoundException extends Exception{
    public WorkerNotFoundException() {
        super("Worker not found");
    }
}
