package com.example.Java_task19.services;

import com.example.Java_task19.models.Worker;
import com.example.Java_task19.repositories.WorkerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class WorkerService {
    private final WorkerRepository workerRepository;

    @Autowired
    public WorkerService(WorkerRepository workerRepository) {
        this.workerRepository = workerRepository;
    }

    public List<Worker> findAll() {
        log.info("Find all workers");
        return workerRepository.findAll();
    }

    @Transactional
    public void save(Worker worker) {
        log.info("Save worker {}", worker);
        workerRepository.save(worker);
    }

    @Transactional
    public void delete(int id) {
        log.info("Delete worker with id = {}", id);
        workerRepository.deleteById(id);
    }
}
