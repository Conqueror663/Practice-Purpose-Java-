package com.Practice.Web.controller;

import com.Practice.Web.exception.ResourceNotFoundException;
import com.Practice.Web.model.Program;
import com.Practice.Web.service.Interface.ProgramServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programs")
public class ProgramController {
    private static final Logger logger = LoggerFactory.getLogger(ProgramController.class);

    @Autowired
    private ProgramServiceInterface programService;

    @PostMapping
    public ResponseEntity<Program> createProgram(@RequestBody Program program) {
        logger.info("Creating a new program");
        Program createdProgram = programService.createProgram(program);
        return ResponseEntity.status(201).body(createdProgram);
    }

    @GetMapping
    public List<Program> getAllPrograms() {
        logger.info("Fetching all programs");
        return programService.getAllPrograms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Program> getProgramById(@PathVariable Long id) {
        logger.info("Fetching program with ID {}", id);
        return programService.getProgramById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Program> updateProgram(@PathVariable Long id, @RequestBody Program program) {
        logger.info("Updating program with ID {}", id);
        // Check if the program exists before attempting to update
        if (!programService.getProgramById(id).isPresent()) {
            throw new ResourceNotFoundException("Program not found with ID: " + id);
        }
        Program updatedProgram = programService.updateProgram(id, program);
        return ResponseEntity.ok(updatedProgram);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProgram(@PathVariable Long id) {
        logger.info("Deleting program with ID {}", id);
        // Check if the program exists before attempting to delete
        if (!programService.getProgramById(id).isPresent()) {
            throw new ResourceNotFoundException("Program not found with ID: " + id);
        }
        programService.deleteProgram(id);
        return ResponseEntity.noContent().build();
    }
}
