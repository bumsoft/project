package com.erica.project.apply.service;

import com.erica.project.User.repository.EmployeeRepository;
import com.erica.project.apply.dto.common.Response_JobPostDto;
import com.erica.project.apply.dto.employer.Request_JobPostDto;
import com.erica.project.apply.dto.employer.Response_ApplicationDto;
import com.erica.project.apply.repository.ApplicationRepository;
import com.erica.project.apply.repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
//Dto변환은 모두 DtoConverter에 만들어놨으니, DtoConverter이용하여 변환하면 됨!!
public class EmployerServiceImpl implements EmployerService {

    private final EmployeeRepository employeeRepository;
    private final JobPostRepository jobPostRepository;
    private final ApplicationRepository applicationRepository;

    // 공고 등록
    @Override
    public boolean saveJobPost(Request_JobPostDto job_postingDto)
    {
        return false;
    }

    // 작성한 공고글 리스트 반환
    @Override
    public List<Response_JobPostDto> getJobPosts(String username)
    {
        return List.of();
    }

    //작성한 공고글 중 RECRUITING상태의 공고글 리스트 반환
    @Override
    public List<Response_JobPostDto> getJobPosts_RECRUITING(String username)
    {
        return List.of();
    }

    //작성한 공고글 중 COMPLETED상태의 공고글 리스트 반환
    @Override
    public List<Response_JobPostDto> getJobPosts_COMPLETED(String username)
    {
        return List.of();
    }

    // 공고글(jobPost_id)의 Application 리스트 반환(dto로)
    @Override
    public List<Response_ApplicationDto> getApplications(Long jobPost_id)
    {
        return List.of();
    }

    //지원서 상태 수락으로 변경 및 공고글 상태 완료로 변경
    @Override
    public boolean acceptApplication(Long jobPost_id, Long application_id)
    {
        return false;
    }

    //공고글 삭제하기
    @Override
    public boolean deleteJobPost(Long jobPost_id)
    {
        return false;
    }
}
