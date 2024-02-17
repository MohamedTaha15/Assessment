package com.anyware.assessment.DAO;

import com.anyware.assessment.model.Teacher;

import java.util.List;

public interface TeacherDAO {
    public List<Teacher> getAll();
    void save (Teacher teacher);
    void update(Teacher teacher);
    void delete(Teacher teacher);
    Teacher findById (Integer id);
}
