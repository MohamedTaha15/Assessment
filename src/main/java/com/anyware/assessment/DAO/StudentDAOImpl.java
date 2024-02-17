package com.anyware.assessment.DAO;

import com.anyware.assessment.model.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class StudentDAOImpl implements StudentDAO{
    private SessionFactory sessionFactory;

    public StudentDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Student findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Student.class, id);
    }

    @Override
    public List<Student> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Student ", Student.class).getResultList();
    }

    @Override
    public void save(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.save(student);
    }

    @Override
    public void update(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.update(student);
    }

    @Override
    public void delete(Student student) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(student);
    }
}
