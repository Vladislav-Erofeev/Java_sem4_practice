package com.example.Java_task19.controllers;

import com.example.Java_task19.dto.ManufactureDTO;
import com.example.Java_task19.models.Manufacture;
import com.example.Java_task19.services.ManufactureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/manufacture")
public class ManufacturesController {
    private final ModelMapper modelMapper;
    private final ManufactureService manufactureService;

    @Autowired
    public ManufacturesController(ModelMapper modelMapper, ManufactureService manufactureService) {
        this.modelMapper = modelMapper;
        this.manufactureService = manufactureService;
    }

    @GetMapping
    public List<ManufactureDTO> getAll() {
        return manufactureService.findAll().stream().map(this::convertToManufactureDTO).collect(Collectors.toList());
    }

    @DeleteMapping("/{id}")
    public HttpStatus deleById(@PathVariable("id")int id) {
        manufactureService.delete(id);
        return HttpStatus.OK;
    }

    @PostMapping
    public HttpStatus add(@RequestBody ManufactureDTO manufactureDTO) {
        manufactureService.save(convertToManufacture(manufactureDTO));
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
