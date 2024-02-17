package com.anyware.assessment.DAO;

import com.anyware.assessment.model.Teacher;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public class TeacherDAOImpl implements TeacherDAO{

    /*private SessionFactory sessionFactory;

    public TeacherDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/
    @PersistenceContext
    private final EntityManager entityManager;
    public TeacherDAOImpl (EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public Teacher findById(Integer id) {
        /*Session session = sessionFactory.getCurrentSession();*/
        return entityManager.find(Teacher.class, id);
    }

    @Override
    @Transactional
    public List<Teacher> getAll() {
        /*Session session = sessionFactory.getCurrentSession();*/
        return entityManager.createQuery("FROM Teacher ", Teacher.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Teacher teacher) {
        /*Session session = sessionFactory.getCurrentSession();*/
        entityManager.persist(teacher);
    }

    @Override
    @Transactional
    public void update(Teacher teacher) {
        /*Session session = sessionFactory.getCurrentSession();*/
        entityManager.merge(teacher);
    }

    @Override
    @Transactional
    public void delete(Teacher teacher) {
        /*Session session = sessionFactory.getCurrentSession();*/
        entityManager.remove(teacher);
    }

}
