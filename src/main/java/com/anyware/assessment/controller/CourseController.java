package com.anyware.assessment.controller;

import com.anyware.assessment.model.Course;
import com.anyware.assessment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "courses")
public class CourseController {
    /*@Autowired
    private CourseService courseService;*/
    private CourseService courseService;
    @Autowired
    public void setCourseService(CourseService courseService){
        this.courseService = courseService;
    }
    @GetMapping
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }

    @PostMapping("create")
    public void CreateCourse(@RequestBody Course course){

        courseService.CreateCourse(course);

    }

    @DeleteMapping("delete/{id}")
    public void DeleteCourse(@PathVariable("id") Integer id){
        courseService.DeleteCourse(id);
    }

    @PutMapping("update/{id}")
    public void UpdateQuiz(@PathVariable("id") Integer id, @RequestParam (required = false) String name){
        courseService.UpdateCourse(id,name);
    }



}
