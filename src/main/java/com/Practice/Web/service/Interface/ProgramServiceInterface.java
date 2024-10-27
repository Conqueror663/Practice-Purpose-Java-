package com.Practice.Web.service.Interface;
import com.Practice.Web.model.Program;

import java.util.List;
import java.util.Optional;

public interface ProgramServiceInterface {
    Program createProgram(Program program);
    List<Program> getAllPrograms();
    Optional<Program> getProgramById(Long id);
    Program updateProgram(Long id, Program program);
    void deleteProgram(Long id);
}