package com.example.Java_spring_task14.dao;

import com.example.Java_spring_task14.models.Worker;
import jakarta.annotation.PostConstruct;
import org.hibernate.jdbc.Work;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkerDAO {
    private ArrayList<Worker> works;

    public WorkerDAO() {
        works = new ArrayList<>();
        works.add(new Worker(0, "Test1", "Test1", "Test1"));
        works.add(new Worker(1, "Test2", "Test2", "Test2"));
        works.add(new Worker(2, "Test3", "Test3", "Test3"));
        works.add(new Worker(3, "Test4", "Test4", "Test4"));
        works.add(new Worker(4, "Test5", "Test5", "Test5"));
        works.add(new Worker(5, "Test6", "Test6", "Test6"));
    }

    public void save(Worker worker) {
        worker.setId(works.size());
        works.add(worker);
    }

    public void delete(int id) {
        works.remove(id);
    }

    public List<Worker> findAll() {
        return works;
    }
}
