package com.Practice.Web.controller;

import com.Practice.Web.model.Subject;
import com.Practice.Web.service.Interface.SubjectServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private static final Logger logger = LoggerFactory.getLogger(SubjectController.class);

    @Autowired
    private SubjectServiceInterface subjectService;

    @PostMapping
    public ResponseEntity<Subject> createSubject(@RequestBody Subject subject) {
        logger.info("Creating a new subject");
        Subject createdSubject = subjectService.createSubject(subject);
        return ResponseEntity.status(201).body(createdSubject);
    }

    @GetMapping
    public List<Subject> getAllSubjects() {
        logger.info("Fetching all subjects");
        return subjectService.getAllSubjects();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subject> getSubjectById(@PathVariable Long id) {
        logger.info("Fetching subject with ID {}", id);
        return subjectService.getSubjectById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Subject> updateSubject(@PathVariable Long id, @RequestBody Subject subject) {
        logger.info("Updating subject with ID {}", id);
        Subject updatedSubject = subjectService.updateSubject(id, subject);
        return ResponseEntity.ok(updatedSubject);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubject(@PathVariable Long id) {
        logger.info("Deleting subject with ID {}", id);
        subjectService.deleteSubject(id);
        return ResponseEntity.noContent().build();
    }
}
