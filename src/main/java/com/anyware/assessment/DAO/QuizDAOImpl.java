package com.anyware.assessment.DAO;

import com.anyware.assessment.model.Course;
import com.anyware.assessment.model.Quiz;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
public class QuizDAOImpl implements QuizDAO{

/*    private final SessionFactory sessionFactory;

    public QuizDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }*/
    @PersistenceContext
    private final EntityManager entityManager;
    public QuizDAOImpl (EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    @Transactional
    public Quiz findById(Integer id) {
        /*Session session = sessionFactory.getCurrentSession();*/
        return entityManager.find(Quiz.class, id);
    }

    @Override
    @Transactional
    public List<Quiz> getAll() {
        /*Session session = sessionFactory.getCurrentSession();*/
        return entityManager.createQuery("SELECT c FROM Quiz c", Quiz.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Quiz quiz) {
        /*Session session = sessionFactory.getCurrentSession();*/
        entityManager.persist(quiz);
    }

    @Override
    @Transactional
    public void update(Quiz quiz) {
        /*Session session = sessionFactory.getCurrentSession();*/
        entityManager.merge(quiz);
    }

    @Override
    @Transactional
    public void delete(Quiz quiz) {
        /*Session session = sessionFactory.getCurrentSession();*/
        entityManager.remove(quiz);
    }

}
