package com.anyware.assessment.DAO;

import com.anyware.assessment.model.Course;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class CourseDAOImpl implements CourseDAO{

/*    ClassPathXmlApplicationContext context = new
            ClassPathXmlApplicationContext("src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml");*/
    private final SessionFactory sessionFactory;
    public CourseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    @Override
    @Transactional
    public Course findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Course.class, id);
    }

    @Override
    @Transactional
    public List<Course> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Course", Course.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.save(course);
    }

    @Override
    @Transactional
    public void update(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.update(course);
    }

    @Override
    @Transactional
    public void delete(Course course) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(course);
    }






}
