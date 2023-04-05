package com.example.Java_spring_task17.dao;

import com.example.Java_spring_task17.models.Worker;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.query.Query;
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

    @Transactional
    public List<Worker> getWorkersWithouManifacture() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Worker> criteriaQuery = builder.createQuery(Worker.class);
        Root<Worker> root = criteriaQuery.from(Worker.class);
        criteriaQuery.select(root).where(builder.isNull(root.get("manufacture")));

        TypedQuery<Worker> query = entityManager.createQuery(criteriaQuery);
        List<Worker> workers = query.getResultList();
        return workers;
    }

    @Transactional
    public Worker findByName(String name) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Worker> criteriaQuery = builder.createQuery(Worker.class);
        Root<Worker> root = criteriaQuery.from(Worker.class);
        criteriaQuery.select(root).where(builder.equal(root.get("firstName"), name));

        TypedQuery<Worker> query = entityManager.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    @Transactional
    public List<Worker> getWithManufacture() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Worker> criteriaQuery = builder.createQuery(Worker.class);
        Root<Worker> root = criteriaQuery.from(Worker.class);
        criteriaQuery.select(root).where(builder.isNotNull(root.get("manufacture")));

        TypedQuery<Worker> query = entityManager.createQuery(criteriaQuery);
        List<Worker> workers = query.getResultList();
        return workers;
    }

    @Transactional
    public List<Worker> greaterThanById(int id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();

        CriteriaQuery<Worker> criteriaQuery = builder.createQuery(Worker.class);
        Root<Worker> root = criteriaQuery.from(Worker.class);
        criteriaQuery.select(root).where(builder.greaterThan(root.get("id"), id));

        TypedQuery<Worker> query = entityManager.createQuery(criteriaQuery);
        List<Worker> workers = query.getResultList();
        return workers;
    }
}
