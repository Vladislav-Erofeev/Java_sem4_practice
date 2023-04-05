package com.example.Java_spring_task15.controllers;

import com.example.Java_spring_task15.dao.WorkerDAO;
import com.example.Java_spring_task15.models.Worker;
import com.example.Java_spring_task15.utils.WorkerNotFoundException;
import com.example.Java_spring_task15.utils.WorkerResponse;
import com.example.Java_spring_task15.utils.WorkerValidator;
import com.example.Java_spring_task15.utils.WrongWorkerDataException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkersController {
    private final WorkerDAO workersService;
    private final WorkerValidator workerValidator;

    @Autowired
    public WorkersController(WorkerDAO workersService, WorkerValidator workerValidator) {
        this.workersService = workersService;
        this.workerValidator = workerValidator;
    }

    @GetMapping
    public List<Worker> getAll() {
        return workersService.findAll();
    }

    @PostMapping
    public HttpStatus add(@RequestBody Worker worker) throws WrongWorkerDataException {
        if(!workerValidator.validate(worker))
            throw new WrongWorkerDataException("Wrong values in fields");
        workersService.save(worker);
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") int id) throws WorkerNotFoundException {
        workersService.delete(id);
        return HttpStatus.OK;
    }

    @ExceptionHandler
    public ResponseEntity<WorkerResponse> notFound(WorkerNotFoundException e) {
        WorkerResponse response = new WorkerResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<WorkerResponse> wrongWorkerFields(WrongWorkerDataException e) {
        WorkerResponse response = new WorkerResponse(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
