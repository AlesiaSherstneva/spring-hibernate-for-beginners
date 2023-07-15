package com.luv2code.cruddemo.dao;

import com.luv2code.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public void save(Student theStudent) {
        entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public List<Student> findAll() {
        // TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student", Student.class);
        // TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName", Student.class);
        TypedQuery<Student> theQuery = entityManager
                .createQuery("FROM Student order by lastName desc", Student.class);

        return theQuery.getResultList();
    }
}