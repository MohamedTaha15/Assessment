package com.anyware.assessment.controller;

import com.anyware.assessment.model.Quiz;
import com.anyware.assessment.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "quizzes")
public class QuizController {

    /*@Autowired
    private QuizService quizService;*/

    private QuizService quizService;
    public void setQuizService(QuizService quizService){
        this.quizService =quizService;
    }

    @GetMapping
    public List<Quiz> getAllQuizzes(){
        return quizService.getAllQuizzes();
    }

    @PostMapping("create")
    public void CreateQuiz(@RequestBody Quiz quiz){

        quizService.CreateQuiz(quiz);

    }

    @DeleteMapping("delete/{id}")
    public void DeleteQuiz(@PathVariable("id") Integer id){
        quizService.DeleteQuiz(id);
    }

    @PutMapping("update/{id}")
    public void UpdateQuiz(@PathVariable("id") Integer id, @RequestParam (required = false) String name){
        quizService.UpdateQuiz(id,name);
    }

}
