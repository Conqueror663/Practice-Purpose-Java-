package com.Practice.Web.service.Interface;

import com.Practice.Web.model.Subject;

import java.util.List;
import java.util.Optional;

public interface SubjectServiceInterface {
    Subject createSubject(Subject subject);
    List<Subject> getAllSubjects();
    Optional<Subject> getSubjectById(Long id);
    Subject updateSubject(Long id, Subject subject);
    void deleteSubject(Long id);
}