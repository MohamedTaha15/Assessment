package com.anyware.assessment.DAO;

import com.anyware.assessment.model.Quiz;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class QuizDAOImpl implements QuizDAO{

    private final SessionFactory sessionFactory;

    public QuizDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    @Transactional
    public Quiz findById(Integer id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Quiz.class, id);
    }

    @Override
    @Transactional
    public List<Quiz> getAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Quiz ", Quiz.class).getResultList();
    }

    @Override
    @Transactional
    public void save(Quiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        session.save(quiz);
    }

    @Override
    @Transactional
    public void update(Quiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        session.update(quiz);
    }

    @Override
    @Transactional
    public void delete(Quiz quiz) {
        Session session = sessionFactory.getCurrentSession();
        session.delete(quiz);
    }

}
