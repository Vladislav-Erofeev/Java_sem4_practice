package com.example.Java_task19.repositories;

import com.example.Java_task19.models.Manufacture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManufactureRepository extends JpaRepository<Manufacture, Integer> {
}
