package com.anyware.assessment.DAO;

import com.anyware.assessment.model.Quiz;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class QuizDAOImpl implements QuizDAO{

    private SessionFactory sessionFactory;

    public QuizDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Quiz findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Quiz.class, id);
    }

    @Override
    public List<Quiz> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Quiz ", Quiz.class).getResultList();
    }

    @Override
    public void save(Quiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        session.save(quiz);
    }

    @Override
    public void update(Quiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        session.update(quiz);
    }

    @Override
    public void delete(Quiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(quiz);
    }

}
