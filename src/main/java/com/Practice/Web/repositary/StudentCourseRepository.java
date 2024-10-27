package com.Practice.Web.repositary;

import com.Practice.Web.model.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
    // Additional query methods can be defined here if needed
}