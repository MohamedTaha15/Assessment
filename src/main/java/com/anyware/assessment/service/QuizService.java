package com.anyware.assessment.service;


import com.anyware.assessment.DAO.QuizDAO;
import com.anyware.assessment.model.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private QuizDAO quizDAO;
    public void setQuizDAO(QuizDAO quizDAO){
        this.quizDAO = quizDAO;
    }

    public List<Quiz> getAllQuizzes(){
        return quizDAO.getAll();
    }

    public void CreateQuiz(Quiz quiz){
        quizDAO.save(quiz);
    }

    public void DeleteQuiz(Integer id){
        Quiz newquiz = quizDAO.findById(id);
        quizDAO.delete(newquiz);
    }

    public void UpdateQuiz(Integer id, String name){
        Quiz newquiz = quizDAO.findById(id);
        Quiz updatequiz = new Quiz(id,name,newquiz.getCourse());
        quizDAO.save(updatequiz);
    }

}
