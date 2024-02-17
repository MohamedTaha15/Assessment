package com.anyware.assessment.DAO;

import com.anyware.assessment.model.Teacher;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class TeacherDAOImpl implements TeacherDAO{

    private SessionFactory sessionFactory;

    public TeacherDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Teacher findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Teacher.class, id);
    }

    @Override
    @Transactional
    public List<Teacher> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Teacher ", Teacher.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.save(teacher);
    }

    @Override
    @Transactional
    public void update(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.update(teacher);
    }

    @Override
    @Transactional
    public void delete(Teacher teacher) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(teacher);
    }

}
