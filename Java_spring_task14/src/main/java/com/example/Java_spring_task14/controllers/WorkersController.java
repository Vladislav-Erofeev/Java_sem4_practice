package com.example.Java_spring_task14.controllers;

import com.example.Java_spring_task14.dao.WorkerDAO;
import com.example.Java_spring_task14.models.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkersController {
    private final WorkerDAO workerDAO;

    @Autowired
    public WorkersController(WorkerDAO workerDAO) {
        this.workerDAO = workerDAO;
    }

    @GetMapping
    public List<Worker> getAll() {
        return workerDAO.findAll();
    }

    @PostMapping
    public HttpStatus add(@RequestBody Worker worker){
        workerDAO.save(worker);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") int id) {
        workerDAO.delete(id);
        return HttpStatus.OK;
    }
}
