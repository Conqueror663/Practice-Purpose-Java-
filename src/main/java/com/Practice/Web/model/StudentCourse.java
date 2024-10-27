package com.Practice.Web.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class StudentCourse {
    private String createdBy = "Usman";
    private String createdDate = "26 OCT";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long studentCourseId;


    @ManyToOne
    @JoinColumn(name = "student_id", nullable = false)
    private Student student;


    @ManyToOne
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

}
