package com.Practice.Web.controller;

import com.Practice.Web.model.Student;
import com.Practice.Web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping
    public List<Student> getStudent(){
        return studentService.getStudentList();
    }

//    @GetMapping("/csrf-token")
//    public CsrfToken getCsrfToken(HttpServletRequest request){
//    return (CsrfToken) request.getAttribute("-csrf");
//    }

    @PostMapping
    public void addStudent(@RequestBody Student student){
            studentService.addStudent(student);
    }

}
