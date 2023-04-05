package com.example.Java_spring_task16.dao;

import com.example.Java_spring_task16.models.Manufacture;
import jakarta.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ManufactureDAO {
    private EntityManager entityManager;

    @Autowired
    public ManufactureDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    public List<Manufacture> findAll() {
        Session session = entityManager.unwrap(Session.class);
        return session.createQuery("from Manufacture", Manufacture.class).getResultList();
    }

    @Transactional
    public void save(Manufacture manufacture) {
        Session session = entityManager.unwrap(Session.class);
        session.persist(manufacture);
    }

    @Transactional
    public void delete(int id) {
        Session session = entityManager.unwrap(Session.class);
        Manufacture manufacture = session.get(Manufacture.class, id);
        session.remove(manufacture);
    }
}
