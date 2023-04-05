package com.example.Java_task19.services;

import com.example.Java_task19.models.Manufacture;
import com.example.Java_task19.repositories.ManufactureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class ManufactureService {
    private final ManufactureRepository manufactureRepository;
    private EmailService emailService;

    @Autowired
    public ManufactureService(ManufactureRepository manufactureRepository) {
        this.manufactureRepository = manufactureRepository;
    }

    @Autowired
    public void setEmailService(EmailService emailService) {
        this.emailService = emailService;
    }

    public List<Manufacture> findAll() {
        log.info("Find all manufactures");
//        emailService.sendEmail("Getting list of manufactures");
        return manufactureRepository.findAll();
    }

    @Transactional
    public void save(Manufacture manufacture) {
        log.info("Save manufacture {}", manufacture);
//        emailService.sendEmail("Save new manufacture");
        manufactureRepository.save(manufacture);
    }

    @Transactional
    public void delete(int id) {
        log.info("Delete manufacture with id = {}", id);
//        emailService.sendEmail("delete manufacture with");
        manufactureRepository.deleteById(id);
    }
}
