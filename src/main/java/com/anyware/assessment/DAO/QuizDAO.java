package com.anyware.assessment.DAO;

import com.anyware.assessment.model.Quiz;

import java.util.List;

public interface QuizDAO {
    Quiz findById(Integer id);

    public List<Quiz> getAll();
    void save (Quiz quiz);
    void update(Quiz quiz);
    void delete(Quiz quiz);
}
