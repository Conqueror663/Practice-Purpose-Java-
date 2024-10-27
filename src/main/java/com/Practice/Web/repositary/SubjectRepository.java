package com.Practice.Web.repositary;

import com.Practice.Web.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubjectRepository extends JpaRepository<Subject, Long> {
    // Additional query methods can be defined here if needed
}
