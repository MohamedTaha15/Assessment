package com.anyware.assessment.DAO;

import com.anyware.assessment.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public class CourseDAOImpl implements CourseDAO{

    private SessionFactory sessionFactory;
    public CourseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Course findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }

    @Override
    public List<Course> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Course", Course.class).getResultList();
    }

    @Override
    public void save(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
    }

    @Override
    public void update(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.update(course);
    }

    @Override
    public void delete(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(course);
    }






}
