package com.luv2code.hibernatedemo.dao;

import com.luv2code.hibernatedemo.entity.Instructor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class AppDAOImpl implements AppDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void save(Instructor theInstructor) {
        entityManager.persist(theInstructor);
    }

    @Override
    @Transactional(readOnly = true)
    public Instructor findInstructorById(int theId) {
        return entityManager.find(Instructor.class, theId);
    }

    @Override
    public void deleteInstructorById(int theId) {
        Instructor tempInstructor = entityManager.find(Instructor.class, theId);
        entityManager.remove(tempInstructor);
    }
}