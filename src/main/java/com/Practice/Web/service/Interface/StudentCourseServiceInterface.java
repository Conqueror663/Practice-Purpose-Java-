package com.Practice.Web.service.Interface;

import com.Practice.Web.model.StudentCourse;

import java.util.List;
import java.util.Optional;

public interface StudentCourseServiceInterface {
    StudentCourse createStudentCourse(StudentCourse studentCourse);
    List<StudentCourse> getAllStudentCourses();
    Optional<StudentCourse> getStudentCourseById(Long id);
    StudentCourse updateStudentCourse(Long id, StudentCourse studentCourse);
    void deleteStudentCourse(Long id);
}