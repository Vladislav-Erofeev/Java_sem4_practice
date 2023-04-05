package com.example.Java_task19.security;

import com.example.Java_task19.models.Person;
import com.example.Java_task19.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RegistrationService {
    private PersonRepository personRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public void registrate(Person person) {
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        person.setRole("ROLE_USER");
        personRepository.save(person);
    }
}
