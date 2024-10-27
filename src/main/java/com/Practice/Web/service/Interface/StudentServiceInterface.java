package com.Practice.Web.service.Interface;


import com.Practice.Web.model.Student;

import java.util.List;
import java.util.Optional;

public interface StudentServiceInterface {
    Student createStudent(Student student);
    List<Student> getAllStudents();
    Optional<Student> getStudentById(Long id);
    Student updateStudent(Long id, Student student);
    void deleteStudent(Long id);
}
