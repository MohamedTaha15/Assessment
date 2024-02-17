package com.anyware.assessment.service;

import com.anyware.assessment.DAO.CourseDAO;
import com.anyware.assessment.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CourseService {

    private CourseDAO courseDAO;
    public void setCourseDAO(CourseDAO courseDAO){
        this.courseDAO = courseDAO;
    }

    public List<Course> getAllCourses(){
        return courseDAO.getAll();
    }

    public void CreateCourse(Course course){
        courseDAO.save(course);
    }

    public void DeleteCourse(Integer id){
        Course newcourse = courseDAO.findById(id);
        courseDAO.delete(newcourse);
    }

    public void UpdateCourse(Integer id, String name){
        Course newcourse = courseDAO.findById(id);
        Course updatecourse = new Course(id,name,newcourse.getStudents(),newcourse.getQuizzes());
        courseDAO.save(updatecourse);
    }

}
