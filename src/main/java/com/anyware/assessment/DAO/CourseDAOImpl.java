package com.anyware.assessment.DAO;

import com.anyware.assessment.model.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
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
    /*private final SessionFactory sessionFactory;
    public CourseDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/

    @PersistenceContext
    private final EntityManager entityManager;
    public CourseDAOImpl (EntityManager entityManager){
        this.entityManager = entityManager;
    }


    @Override
    @Transactional
    public Course findById(Integer id) {
        /*Session session = sessionFactory.getCurrentSession();*/
        return entityManager.find(Course.class, id);

    }

    @Override
    @Transactional
    public List<Course> getAll() {
        /*Session session = sessionFactory.getCurrentSession();*/
        return entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Course course) {
        /*Session session = sessionFactory.getCurrentSession();*/
        entityManager.persist(course);

    }

    @Override
    @Transactional
    public void update(Course course) {
        /*Session session = sessionFactory.getCurrentSession();*/
        entityManager.merge(course);
    }

    @Override
    @Transactional
    public void delete(Course course) {
        /*Session session = sessionFactory.getCurrentSession();*/
        entityManager.remove(course);
    }






}
