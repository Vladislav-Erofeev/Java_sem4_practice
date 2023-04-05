package com.example.Java_spring_task16.controllers;

import com.example.Java_spring_task16.dao.ManufactureDAO;
import com.example.Java_spring_task16.dto.ManufactureDTO;
import com.example.Java_spring_task16.models.Manufacture;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/manufacture")
public class ManufacturesController {
    private final ManufactureDAO manufactureDAO;
    private final ModelMapper modelMapper;

    @Autowired
    public ManufacturesController(ManufactureDAO manufactureDAO, ModelMapper modelMapper) {
        this.manufactureDAO = manufactureDAO;
        this.modelMapper = modelMapper;
    }

    @GetMapping
    public List<ManufactureDTO> getAll() {
        return manufactureDAO.findAll().stream().map(this::convertToManufactureDTO).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleById(@PathVariable("id")int id) {
        manufactureDAO.delete(id);
        return HttpStatus.OK;
    }

    @PostMapping
    public HttpStatus add(@RequestBody ManufactureDTO manufactureDTO) {
        manufactureDAO.save(convertToManufacture(manufactureDTO));
        return HttpStatus.OK;
    }

    private ManufactureDTO convertToManufactureDTO(Manufacture manufacture) {
        return modelMapper.map(manufacture, ManufactureDTO.class);
    }

    private Manufacture convertToManufacture(ManufactureDTO manufactureDTO) {
//        Manufacture manufacture =
        return modelMapper.map(manufactureDTO, Manufacture.class);
    }
}
