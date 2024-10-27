package com.Practice.Web.service;

import com.Practice.Web.exception.ResourceNotFoundException;
import com.Practice.Web.model.Program;
import com.Practice.Web.repositary.ProgramRepository;
import com.Practice.Web.service.Interface.ProgramServiceInterface;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProgramService implements ProgramServiceInterface {
    private static final Logger logger = LoggerFactory.getLogger(ProgramService.class);

    @Autowired
    private ProgramRepository programRepository;

    @Override
    public Program createProgram(Program program) {
        logger.info("Creating a new program");
        return programRepository.save(program);
    }

    @Override
    public List<Program> getAllPrograms() {
        logger.info("Fetching all programs");
        return programRepository.findAll();
    }

    @Override
    public Optional<Program> getProgramById(Long id) {
        logger.info("Fetching program with ID {}", id);
        return Optional.ofNullable(programRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Program not found with ID: " + id)));
    }

    @Override
    public Program updateProgram(Long id, Program program) {
        logger.info("Updating program with ID {}", id);
        if (!programRepository.existsById(id)) {
            throw new ResourceNotFoundException("Program not found with ID: " + id);
        }
        program.setProgramId(id);
        return programRepository.save(program);
    }

    @Override
    public void deleteProgram(Long id) {
        logger.info("Deleting program with ID {}", id);
        if (!programRepository.existsById(id)) {
            throw new ResourceNotFoundException("Program not found with ID: " + id);
        }
        programRepository.deleteById(id);
    }
}
