package com.example.Java_spring_task18.services;

import com.example.Java_spring_task18.models.Worker;
import com.example.Java_spring_task18.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class WorkerService {
    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    @Transactional(readOnly = true)
    public List<Worker> findAll() {
        return workerRepository.findAll();
    }

    @Transactional
    public void save(Worker worker) {
        workerRepository.save(worker);
    }

    @Transactional
    public void delete(int id) {
        workerRepository.deleteById(id);
    }
}
