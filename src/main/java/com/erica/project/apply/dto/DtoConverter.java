package com.erica.project.apply.dto;

import com.erica.project.apply.domain.Application;
import com.erica.project.apply.domain.JobPost;
import com.erica.project.apply.dto.common.Response_JobPostDto;
import com.erica.project.apply.dto.employee.Response_PostwithApplicationDto;
import com.erica.project.apply.dto.employer.Response_ApplicationDto;

import java.util.List;
import java.util.Optional;

//엔티티를 dto로 변환하는 메서드들을 갖는 클래스
public class DtoConverter {

    public static Response_JobPostDto ToJobPostDto(JobPost jobPost)
    {
        Response_JobPostDto dto = new Response_JobPostDto();

        dto.setJobPost_id(jobPost.getJobPost_id());
        dto.setEmployerCompname(jobPost.getEmployerCompname());
        dto.setLocation(jobPost.getLocation());
        dto.setSalaryPerTime(jobPost.getSalaryPerTime());
        dto.setWorkDate(jobPost.getWorkDate());
        dto.setWorkTimeFrom(jobPost.getWorkTimeFrom());
        dto.setWorkTimeTo(jobPost.getWorkTimeTo());
        dto.setPostDate(jobPost.getPostDate());
        dto.setJobPostState(jobPost.getJobPostState());

        return dto;
    }

    public static Response_PostwithApplicationDto ToPostwithApplicationDto(Application application)
    {
        Response_PostwithApplicationDto dto = new Response_PostwithApplicationDto();
        dto.setJobPost_id(application.getJobPost().getJobPost_id());
        dto.setEmployerCompname(application.getJobPost().getEmployerCompname());
        dto.setLocation(application.getJobPost().getLocation());
        dto.setSalaryPerTime(application.getJobPost().getSalaryPerTime());
        dto.setWorkDate(application.getJobPost().getWorkDate());
        dto.setWorkTimeFrom(application.getJobPost().getWorkTimeFrom());
        dto.setWorkTimeTo(application.getJobPost().getWorkTimeTo());
        dto.setPostDate(application.getJobPost().getPostDate());
        dto.setJobPostState(application.getJobPost().getJobPostState());
        dto.setApplicationState(application.getApplicationState());
        dto.setApplyDate(application.getApplyDate());
        dto.setApplicationState(application.getApplicationState());

        return dto;
    }

    static Response_ApplicationDto ToApplicationDto(Application application)
    {
        Response_ApplicationDto dto = new Response_ApplicationDto();
        dto.setName(application.getEmployee().getName());
        dto.setEmployeeCareer(application.getEmployee().getEmployeeCareer());
        dto.setEmployeeLevel(application.getEmployee().getEmployeeLevel());
        dto.setApplyDate(application.getApplyDate());
        dto.setApplicationState(application.getApplicationState());

        return dto;
    }

}
