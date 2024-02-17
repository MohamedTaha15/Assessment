package com.anyware.assessment.DAO;

import com.anyware.assessment.model.Course;

import java.util.List;

public interface CourseDAO {
    public List<Course> getAll();
    void save (Course course);
    void update(Course course);
    void delete(Course course);
    Course findById (Integer id);
}
