package com.example.Java_spring_task17.controllers;


import com.example.Java_spring_task17.dao.WorkerDAO;
import com.example.Java_spring_task17.dto.WorkerDTO;
import com.example.Java_spring_task17.models.Worker;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/workers")
public class WorkersController {
    private final WorkerDAO workerDAO;
    private final ModelMapper modelMapper;

    @Autowired
    public WorkersController(WorkerDAO workersDao, ModelMapper modelMapper) {
        this.workerDAO = workersDao;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<WorkerDTO> getAll() {
        return workerDAO.findAll().stream().map(this::convertToWorkerDTO).collect(Collectors.toList());
    }

    @PostMapping
    public HttpStatus add(@RequestBody WorkerDTO workerDTO) {
        workerDAO.save(convertToWorker(workerDTO));
        return HttpStatus.OK;
    }

    @DeleteMapping("/{id}")
    public HttpStatus delete(@PathVariable("id") int id) {
        workerDAO.delete(id);
        return HttpStatus.OK;
    }

    @GetMapping("/without")
    public List<WorkerDTO> getWithout() {
        List<Worker> workers = workerDAO.getWorkersWithouManifacture();
        return workers.stream().map(this::convertToWorkerDTO).collect(Collectors.toList());
    }

    @GetMapping("/name")
    public WorkerDTO findByName(@RequestParam("name")String name) {
        Worker worker = workerDAO.findByName(name);
        return convertToWorkerDTO(worker);
    }

    @GetMapping("/with")
    public List<WorkerDTO> getWith() {
        List<Worker> workers = workerDAO.getWithManufacture();
        return workers.stream().map(this::convertToWorkerDTO).collect(Collectors.toList());
    }

    @GetMapping("/gt")
    public List<WorkerDTO> greaterThan(@RequestParam("id")int id) {
        List<Worker> workers = workerDAO.greaterThanById(id);
        return workers.stream().map(this::convertToWorkerDTO).collect(Collectors.toList());
    }

    private WorkerDTO convertToWorkerDTO(Worker worker) {
        WorkerDTO workerDTO = modelMapper.map(worker, WorkerDTO.class);
        return workerDTO;
    }

    private Worker convertToWorker(WorkerDTO workerDTO) {
        return modelMapper.map(workerDTO, Worker.class);
    }
}
