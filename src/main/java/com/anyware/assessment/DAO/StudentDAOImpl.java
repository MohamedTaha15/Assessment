package com.anyware.assessment.DAO;

import com.anyware.assessment.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class StudentDAOImpl implements StudentDAO{
    private SessionFactory sessionFactory;

    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Student findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Override
    @Transactional
    public List<Student> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Student ", Student.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    @Transactional
    public void update(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.update(student);
    }

    @Override
    @Transactional
    public void delete(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(student);
    }
}
