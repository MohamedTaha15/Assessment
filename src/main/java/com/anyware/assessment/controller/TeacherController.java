package com.anyware.assessment.controller;

import com.anyware.assessment.model.Teacher;
import com.anyware.assessment.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "teachers")
public class TeacherController {
    /*@Autowired
    private TeacherService teacherService;*/

    private TeacherService teacherService;
    @Autowired
    public void setTeacherService(TeacherService teacherService){
        this.teacherService = teacherService;
    }

    @GetMapping
    public List<Teacher> getAllteachers(){
        return teacherService.getAllteachers();
    }

    @PostMapping("create")
    public void CreateTeacher(@RequestBody Teacher teacher){

        teacherService.CreateTeacher(teacher);

    }

    @DeleteMapping("delete/{id}")
    public void DeleteTeacher(@PathVariable("id") Integer id){
        teacherService.DeleteTeacher(id);
    }

    @PutMapping("update/{id}")
    public void UpdateTeacher(@PathVariable("id") Integer id, @RequestParam (required = false) String name){
        teacherService.UpdateTeacher(id,name);
    }
}
