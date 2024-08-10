package com.erica.project.apply.repository;

import com.erica.project.apply.domain.Application;
import com.erica.project.apply.domain.JobPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface JobPostRepository extends JpaRepository<JobPost,Long> {

    static List <JobPost> findByApplication(Optional<Application> application) {
    };

    // DB에서 가져와야지
    List<JobPost> findByLocationAndState(String location, String jobPostState);

}
