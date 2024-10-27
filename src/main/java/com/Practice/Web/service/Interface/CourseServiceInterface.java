package com.Practice.Web.service.Interface;
import com.Practice.Web.model.Course;

import java.util.List;
import java.util.Optional;

public interface CourseServiceInterface {
    Course createCourse(Course course);
    List<Course> getAllCourses();
    Optional<Course> getCourseById(Long id);
    Course updateCourse(Long id, Course course);
    void deleteCourse(Long id);
}