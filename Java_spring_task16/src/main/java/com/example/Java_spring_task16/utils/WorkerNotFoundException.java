package com.example.Java_spring_task16.utils;

public class WorkerNotFoundException extends Exception{
    public WorkerNotFoundException() {
        super("Worker not found");
    }
}
