package com.Practice.Web.service;

import com.Practice.Web.exception.ResourceNotFoundException;
import com.Practice.Web.model.Subject;
import com.Practice.Web.repositary.SubjectRepository;
import com.Practice.Web.service.Interface.SubjectServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SubjectService implements SubjectServiceInterface {
    private static final Logger logger = LoggerFactory.getLogger(SubjectService.class);

    @Autowired
    private SubjectRepository subjectRepository;

    @Override
    public Subject createSubject(Subject subject) {
        logger.info("Creating a new subject");
        return subjectRepository.save(subject);
    }

    @Override
    public List<Subject> getAllSubjects() {
        logger.info("Fetching all subjects");
        return subjectRepository.findAll();
    }

    @Override
    public Optional<Subject> getSubjectById(Long id) {
        logger.info("Fetching subject with ID {}", id);
        return Optional.ofNullable(subjectRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Subject not found with ID: " + id)));
    }

    @Override
    public Subject updateSubject(Long id, Subject subject) {
        logger.info("Updating subject with ID {}", id);
        if (!subjectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Subject not found with ID: " + id);
        }
        subject.setSubjectId(id);
        return subjectRepository.save(subject);
    }

    @Override
    public void deleteSubject(Long id) {
        logger.info("Deleting subject with ID {}", id);
         if (!subjectRepository.existsById(id)) {
            throw new ResourceNotFoundException("Subject not found with ID: " + id);
        }
        subjectRepository.deleteById(id);
    }
}

