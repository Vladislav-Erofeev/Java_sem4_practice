package com.example.Java_spring_task16.dao;

import com.example.Java_spring_task16.models.Worker;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@Component
public class WorkerDAO {
    private EntityManager entityManager;

    @Autowired
    public WorkerDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Worker> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("select w from Worker w", Worker.class).getResultList();
    }

    @Transactional
    public void save(Worker worker) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(worker);
    }

    @Transactional
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Worker worker = session.get(Worker.class, id);
        session.remove(worker);
    }
}
