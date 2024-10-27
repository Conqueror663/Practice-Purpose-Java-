package com.Practice.Web.service;

import com.Practice.Web.exception.ResourceNotFoundException;
import com.Practice.Web.model.Student;
import com.Practice.Web.repositary.StudentRepository;
import com.Practice.Web.service.Interface.StudentServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService implements StudentServiceInterface {
    private static final Logger logger = LoggerFactory.getLogger(StudentService.class);

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Student createStudent(Student student) {
        logger.info("Creating a new student");
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudents() {
        logger.info("Fetching all students");
        return studentRepository.findAll();
    }

    @Override
    public Optional<Student> getStudentById(Long id) {
        logger.info("Fetching student with ID {}", id);
        return Optional.ofNullable(studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with ID: " + id)));
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        logger.info("Updating student with ID {}", id);
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Student not found with ID: " + id);
        }
        student.setStudentId(id);
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudent(Long id) {
        logger.info("Deleting student with ID {}", id);
        if (!studentRepository.existsById(id)) {
            throw new ResourceNotFoundException("Student not found with ID: " + id);
        }
        studentRepository.deleteById(id);
    }
}
