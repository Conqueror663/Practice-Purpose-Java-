package com.Practice.Web.service;

import com.Practice.Web.exception.ResourceNotFoundException;
import com.Practice.Web.model.Course;
import com.Practice.Web.repositary.CourseRepository;
import com.Practice.Web.service.Interface.CourseServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService implements CourseServiceInterface {
    private static final Logger logger = LoggerFactory.getLogger(CourseService.class);

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course) {
        logger.info("Creating a new course");
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        logger.info("Fetching all courses");
        return courseRepository.findAll();
    }

    @Override
    public Optional<Course> getCourseById(Long id) {
        logger.info("Fetching course with ID {}", id);
        return courseRepository.findById(id);
    }

    @Override
    public Course updateCourse(Long id, Course course) {
        logger.info("Updating course with ID {}", id);
        if (!courseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Course not found with ID: " + id);
        }
        course.setCourseId(id);
        return courseRepository.save(course);
    }

    @Override
    public void deleteCourse(Long id) {
        logger.info("Deleting course with ID {}", id);
        if (!courseRepository.existsById(id)) {
            throw new ResourceNotFoundException("Course not found with ID: " + id);
        }
        courseRepository.deleteById(id);
    }
}
