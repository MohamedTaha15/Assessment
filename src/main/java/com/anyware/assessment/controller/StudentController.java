package com.anyware.assessment.controller;


import com.anyware.assessment.model.Student;
import com.anyware.assessment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "students")
public class StudentController {
    /*@Autowired
    private StudentService studentService;*/

    private StudentService studentService;
    public void setStudentService(StudentService studentService){
        this.studentService=studentService;
    }

    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }

    @PostMapping("create")
    public void CreateStudent(@RequestBody Student student){

        studentService.CreateStudent(student);

    }

    @DeleteMapping("delete/{id}")
    public void DeleteStudent(@PathVariable("id") Integer id){
        studentService.DeleteStudent(id);
    }

    @PutMapping("update/{id}")
    public void UpdateStudent(@PathVariable("id") Integer id, @RequestParam (required = false) String name){
        studentService.UpdateStudent(id,name);
    }
}
