package com.Practice.Web.repositary;

import com.Practice.Web.model.Program;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramRepository extends JpaRepository<Program, Long> {
    // Additional query methods can be defined here if needed
}
