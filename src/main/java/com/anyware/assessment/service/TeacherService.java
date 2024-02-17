package com.anyware.assessment.service;


import com.anyware.assessment.DAO.TeacherDAO;
import com.anyware.assessment.model.Teacher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private TeacherDAO teacherDAO;
    public void setTeacherDAO(TeacherDAO teacherDAO){
        this.teacherDAO = teacherDAO;
    }

    public List<Teacher> getAllteachers(){
        return teacherDAO.getAll();
    }

    public void CreateTeacher(Teacher teacher){
        teacherDAO.save(teacher);
    }

    public void DeleteTeacher(Integer id){
        Teacher newteacher = teacherDAO.findById(id);
        teacherDAO.delete(newteacher);
    }

    public void UpdateTeacher(Integer id, String name){
        Teacher newteacher = teacherDAO.findById(id);
        Teacher updateteacher = new Teacher(id,name,newteacher.getCourses());
        teacherDAO.save(updateteacher);
    }

}
