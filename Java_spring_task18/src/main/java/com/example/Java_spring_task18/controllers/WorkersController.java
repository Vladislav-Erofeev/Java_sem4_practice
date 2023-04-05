package com.example.Java_spring_task18.controllers;

import com.example.Java_spring_task18.dto.WorkerDTO;
import com.example.Java_spring_task18.models.Worker;
import com.example.Java_spring_task18.services.WorkerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workers")
public class WorkersController {
    private final ModelMapper modelMapper;
    private final WorkerService workerService;

    @Autowired
    public WorkersController(ModelMapper modelMapper, WorkerService workerService) {
        this.modelMapper = modelMapper;
        this.workerService = workerService;
    }

    @GetMapping
    public List<WorkerDTO> getAll() {
        return workerService.findAll().stream().map(this::convertToWorkerDTO).collect(Collectors.toList());
    }

    @PostMapping
    public HttpStatus add(@RequestBody WorkerDTO workerDTO) {
        workerService.save(convertToWorker(workerDTO));
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") int id) {
        workerService.delete(id);
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
