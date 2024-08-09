package com.erica.project.apply.repository;

import com.erica.project.apply.domain.Job_Posting;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface Job_PostingRepository extends JpaRepository<Job_Posting,Long> {

    List<Job_Posting> findByLocation(String loc);

    List<Job_Posting> findbyKeyword(String keyword);
    List<Job_Posting> findByDate(LocalDate date);
    List<Job_Posting> findByEmployee(Long id);

    Optional<Job_Posting> findById(Long jobId);
}
