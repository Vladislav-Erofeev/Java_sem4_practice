package com.example.Java_spring_task18.services;

import com.example.Java_spring_task18.models.Manufacture;
import com.example.Java_spring_task18.repositories.ManufactureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class ManufactureService {
    private final ManufactureRepository manufactureRepository;

    @Autowired
    public ManufactureService(ManufactureRepository manufactureRepository) {
        this.manufactureRepository = manufactureRepository;
    }

    public List<Manufacture> findAll() {
        log.info("Find all manufactures");
        return manufactureRepository.findAll();
    }

    @Transactional
    public void save(Manufacture manufacture) {
        log.info("Save manufacture {}", manufacture);
        manufactureRepository.save(manufacture);
    }

    @Transactional
    public void delete(int id) {
        log.info("Delete manufacture with id = {}", id);
        manufactureRepository.deleteById(id);
    }
}
