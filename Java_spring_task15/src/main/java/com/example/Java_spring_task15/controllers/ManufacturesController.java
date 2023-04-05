package com.example.Java_spring_task15.controllers;

import com.example.Java_spring_task15.dao.ManufactureDAO;
import com.example.Java_spring_task15.models.Manufacture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/manufacture")
public class ManufacturesController {
    private final ManufactureDAO manufactureDAO;

    @Autowired
    public ManufacturesController(ManufactureDAO manufactureDAO) {
        this.manufactureDAO = manufactureDAO;
    }

    @GetMapping
    public List<Manufacture> getAll() {
        return manufactureDAO.findAll();
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleById(@PathVariable("id")int id) {
        manufactureDAO.delete(id);
        return HttpStatus.OK;
    }

    @PostMapping
    public HttpStatus add(@RequestBody Manufacture manufacture) {
        manufactureDAO.save(manufacture);
        return HttpStatus.OK;
    }
}
