package com.anyware.assessment.DAO;

import com.anyware.assessment.model.Student;

import java.util.List;

public interface StudentDAO {
    public List<Student> getAll();
    void save (Student student);
    void update(Student student);
    void delete(Student student);
    Student findById (Integer id);
}
