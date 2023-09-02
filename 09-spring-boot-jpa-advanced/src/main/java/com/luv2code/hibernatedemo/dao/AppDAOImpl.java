package com.luv2code.hibernatedemo.dao;

import com.luv2code.hibernatedemo.entity.Course;
import com.luv2code.hibernatedemo.entity.Instructor;
import com.luv2code.hibernatedemo.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    @Override
    @Transactional(readOnly = true)
    public InstructorDetail findInstructorDetailById(int theId) {
        return entityManager.find(InstructorDetail.class, theId);
    }

    @Override
    public void deleteInstructorDetailById(int theId) {
        InstructorDetail tempInstructorDetail = entityManager.find(InstructorDetail.class, theId);
        tempInstructorDetail.getInstructor().setInstructorDetail(null);
        entityManager.remove(tempInstructorDetail);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Course> findCoursesByInstructorId(int theId) {
        TypedQuery<Course> query = entityManager.createQuery
                ("from Course where instructor.id = :data", Course.class);
        query.setParameter("data", theId);

        return query.getResultList();
    }

    @Override
    @Transactional(readOnly = true)
    public Instructor findInstructorByIdJoinFetch(int theId) {
        TypedQuery<Instructor> query = entityManager.createQuery
                ("SELECT i FROM Instructor i JOIN FETCH i.instructorDetail JOIN FETCH i.courses" +
                        " WHERE i.id = :data", Instructor.class);
        query.setParameter("data", theId);

        return query.getSingleResult();
    }

    @Override
    public void update(Instructor tempInstructor) {
        entityManager.merge(tempInstructor);
    }
}