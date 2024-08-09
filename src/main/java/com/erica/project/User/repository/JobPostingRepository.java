package com.erica.project.User.repository;

import com.erica.project.User.domain.Employee;
import com.erica.project.apply.domain.Job_Posting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface JobPostingRepository extends JpaRepository<Job_Posting,Integer> {
    List<Job_Posting> findbyKeyword(String keyword);
    List<Job_Posting> findByDate(LocalDate date);
    List<Job_Posting> findByEmployee(Long id);

}
