package com.Practice.Web.repositary;

import com.Practice.Web.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    // Additional query methods can be defined here if needed
}
