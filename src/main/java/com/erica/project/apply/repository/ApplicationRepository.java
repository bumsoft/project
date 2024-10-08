package com.erica.project.apply.repository;

import com.erica.project.apply.domain.Application;
import com.erica.project.apply.domain.ApplicationState;
import com.erica.project.apply.domain.JobPost;
import com.erica.project.apply.domain.JobPostState;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    List<Application> findByEmployeeUsername(String username);

    List<Application> findByEmployeeUsernameAndApplicationState(String username, ApplicationState state);

    List<Application> findByEmployeeUsernameAndJobPostJobPostState(String username, JobPostState state);

    List<Application> findByJobPost_JobPostId(Long jobPost_id);

    List<Application> findByJobPost_JobPostIdAndApplicationState(Long jobPost_id, ApplicationState state);

    boolean existsByJobPostAndEmployeeUsername(JobPost jobPost, String username);




}
