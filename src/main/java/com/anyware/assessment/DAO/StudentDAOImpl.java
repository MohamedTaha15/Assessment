package com.anyware.assessment.DAO;

import com.anyware.assessment.model.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDAOImpl implements StudentDAO{
    /*private SessionFactory sessionFactory;

    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/

    @PersistenceContext
    private final EntityManager entityManager;
    public StudentDAOImpl (EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Student findById(Integer id) {
        /*Session session = sessionFactory.getCurrentSession();*/
        return entityManager.find(Student.class, id);
    }

    @Override
    @Transactional
    public List<Student> getAll() {
        /*Session session = sessionFactory.getCurrentSession();*/
        return entityManager.createQuery("FROM Student ", Student.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Student student) {
        /*Session session = sessionFactory.getCurrentSession();*/
        entityManager.persist(student);
    }

    @Override
    @Transactional
    public void update(Student student) {
        /*Session session = sessionFactory.getCurrentSession();*/
        entityManager.merge(student);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        /*Session session = sessionFactory.getCurrentSession();*/
        entityManager.remove(student);
    }
}
