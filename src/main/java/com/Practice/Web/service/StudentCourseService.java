package com.Practice.Web.service;

import com.Practice.Web.exception.ResourceNotFoundException;
import com.Practice.Web.model.StudentCourse;
import com.Practice.Web.repositary.StudentCourseRepository;
import com.Practice.Web.service.Interface.StudentCourseServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentCourseService implements StudentCourseServiceInterface {
    private static final Logger logger = LoggerFactory.getLogger(StudentCourseService.class);

    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Override
    public StudentCourse createStudentCourse(StudentCourse studentCourse) {
        logger.info("Creating a new student course");
        return studentCourseRepository.save(studentCourse);
    }

    @Override
    public List<StudentCourse> getAllStudentCourses() {
        logger.info("Fetching all student courses");
        return studentCourseRepository.findAll();
    }

    @Override
    public Optional<StudentCourse> getStudentCourseById(Long id) {
        logger.info("Fetching student course with ID {}", id);
        return Optional.ofNullable(studentCourseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("StudentCourse not found with ID: " + id)));
    }

    @Override
    public StudentCourse updateStudentCourse(Long id, StudentCourse studentCourse) {
        logger.info("Updating student course with ID {}", id);
        if (!studentCourseRepository.existsById(id)) {
            throw new ResourceNotFoundException("StudentCourse not found with ID: " + id);
        }
        studentCourse.setStudentCourseId(id);
        return studentCourseRepository.save(studentCourse);
    }

    @Override
    public void deleteStudentCourse(Long id) {
        logger.info("Deleting student course with ID {}", id);
        if (!studentCourseRepository.existsById(id)) {
            throw new ResourceNotFoundException("StudentCourse not found with ID: " + id);
        }
        studentCourseRepository.deleteById(id);
    }
}
