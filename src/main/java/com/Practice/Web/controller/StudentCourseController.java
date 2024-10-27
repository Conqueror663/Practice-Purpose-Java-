package com.Practice.Web.controller;

import com.Practice.Web.model.StudentCourse;
import com.Practice.Web.service.Interface.StudentCourseServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student-courses")
public class StudentCourseController {
    private static final Logger logger = LoggerFactory.getLogger(StudentCourseController.class);

    @Autowired
    private StudentCourseServiceInterface studentCourseService;

    @PostMapping
    public StudentCourse createStudentCourse(@RequestBody StudentCourse studentCourse) {
        logger.info("Creating a new student-course relationship");
        return studentCourseService.createStudentCourse(studentCourse);
    }

    @GetMapping
    public List<StudentCourse> getAllStudentCourses() {
        logger.info("Fetching all student-course relationships");
        return studentCourseService.getAllStudentCourses();
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentCourse> getStudentCourseById(@PathVariable Long id) {
        logger.info("Fetching student-course relationship with ID {}", id);
        return ResponseEntity.ok(studentCourseService.getStudentCourseById(id).orElse(null));
    }

    @PutMapping("/{id}")
    public StudentCourse updateStudentCourse(@PathVariable Long id, @RequestBody StudentCourse studentCourse) {
        logger.info("Updating student-course relationship with ID {}", id);
        return studentCourseService.updateStudentCourse(id, studentCourse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudentCourse(@PathVariable Long id) {
        logger.info("Deleting student-course relationship with ID {}", id);
        studentCourseService.deleteStudentCourse(id);
        return ResponseEntity.noContent().build();
    }
}
