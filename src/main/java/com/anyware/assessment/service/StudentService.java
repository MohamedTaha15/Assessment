package com.anyware.assessment.service;


import com.anyware.assessment.DAO.StudentDAO;
import com.anyware.assessment.model.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentDAO studentDAO;
    public void setStudentDAO(StudentDAO studentDAO){
        this.studentDAO = studentDAO;
    }

    public List<Student> getAllStudents(){
        return studentDAO.getAll();
    }

    public void CreateStudent(Student student){
        studentDAO.save(student);
    }

    public void DeleteStudent(Integer id){
        Student newstudent = studentDAO.findById(id);
        studentDAO.delete(newstudent);
    }

    public void UpdateStudent(Integer id, String name){
        Student newstudent = studentDAO.findById(id);
        Student updatestudent = new Student(id,name,newstudent.getCourses(),newstudent.getTeachers(),newstudent.getQuizzes());
        studentDAO.save(updatestudent);
    }

}
