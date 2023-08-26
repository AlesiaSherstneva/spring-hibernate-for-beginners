package com.luv2code.hibernatedemo.dao;

import com.luv2code.hibernatedemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class AppDAOImpl implements AppDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }
}