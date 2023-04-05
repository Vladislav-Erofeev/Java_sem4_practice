package com.example.Java_task19.controllers;

import com.example.Java_task19.dto.PersonDTO;
import com.example.Java_task19.models.Person;
import com.example.Java_task19.security.PersonDetails;
import com.example.Java_task19.security.RegistrationService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    private RegistrationService registrationService;
    private final ModelMapper modelMapper;

    @Autowired
    public IndexController(RegistrationService registrationService, ModelMapper modelMapper) {
        this.registrationService = registrationService;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/")
    public String indexPage() {
        return "index";
    }

    @PostMapping("/registrate")
    public HttpStatus registrate(@RequestBody PersonDTO personDTO) {
        Person person = convertToPerson(personDTO);
        registrationService.registrate(person);
        return HttpStatus.OK;
    }

    @GetMapping("/info")
    public PersonDTO getUserInfo() {
        PersonDetails personDetails = (PersonDetails) SecurityContextHolder.getContext()
                .getAuthentication().getPrincipal();
        return convertToPersonDTO(personDetails.getPerson());
    }

    private Person convertToPerson(PersonDTO personDTO) {
        return modelMapper.map(personDTO, Person.class);
    }

    private PersonDTO convertToPersonDTO(Person person) {
        return modelMapper.map(person, PersonDTO.class);
    }
}
