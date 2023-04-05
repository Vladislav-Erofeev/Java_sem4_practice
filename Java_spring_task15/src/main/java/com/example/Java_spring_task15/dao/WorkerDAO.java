package com.example.Java_spring_task15.dao;

import com.example.Java_spring_task15.models.Worker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Component
@NoArgsConstructor
public class WorkerDAO {
    @PersistenceContext
    private EntityManager entityManager;

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
