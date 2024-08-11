package com.erica.project.apply.repository;

import com.erica.project.apply.domain.Application;
import com.erica.project.apply.domain.JobPost;
import com.erica.project.apply.domain.JobPostState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface JobPostRepository extends JpaRepository<JobPost,Long> {

    List <JobPost> findByApplication(Optional<Application> application);

    // DB에서 가져와야지
    List<JobPost> findByLocationAndJobPostState(String location, JobPostState jobPostState);
}
