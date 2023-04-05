package com.example.Java_spring_task16.controllers;

import com.example.Java_spring_task16.dao.WorkerDAO;
import com.example.Java_spring_task16.dto.WorkerDTO;
import com.example.Java_spring_task16.models.Worker;
import com.example.Java_spring_task16.utils.WorkerNotFoundException;
import com.example.Java_spring_task16.utils.WorkerResponse;
import com.example.Java_spring_task16.utils.WorkerValidator;
import com.example.Java_spring_task16.utils.WrongWorkerDataException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workers")
public class WorkersController {
    private final WorkerDAO workersService;
    private final WorkerValidator workerValidator;
    private final ModelMapper modelMapper;

    @Autowired
    public WorkersController(WorkerDAO workersService, WorkerValidator workerValidator, ModelMapper modelMapper) {
        this.workersService = workersService;
        this.workerValidator = workerValidator;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<WorkerDTO> getAll() {
        return workersService.findAll().stream().map(this::convertToWorkerDTO).collect(Collectors.toList());
    }

    @PostMapping
    public HttpStatus add(@RequestBody WorkerDTO workerDTO) throws WrongWorkerDataException {
        workersService.save(convertToWorker(workerDTO));
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") int id) throws WorkerNotFoundException {
        workersService.delete(id);
        return HttpStatus.OK;
    }

    private WorkerDTO convertToWorkerDTO(Worker worker) {
        WorkerDTO workerDTO = modelMapper.map(worker, WorkerDTO.class);
        return workerDTO;
    }

    private Worker convertToWorker(WorkerDTO workerDTO) {
        return modelMapper.map(workerDTO, Worker.class);
    }
}
