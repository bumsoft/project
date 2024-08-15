package com.erica.project.apply.service;

import com.erica.project.User.repository.EmployeeRepository;
import com.erica.project.User.repository.EmployerRepository;
import com.erica.project.apply.domain.Application;
import com.erica.project.apply.domain.JobPost;
import com.erica.project.apply.domain.JobPostState;
import com.erica.project.apply.dto.DtoConverter;
import com.erica.project.apply.dto.common.Response_JobPostDto;
import com.erica.project.apply.dto.employer.Request_JobPostDto;
import com.erica.project.apply.dto.employer.Response_ApplicationDto;
import com.erica.project.apply.repository.ApplicationRepository;
import com.erica.project.apply.repository.JobPostRepository;
import com.erica.project.exception.JobPostNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
//Dto변환은 모두 DtoConverter에 만들어놨으니, DtoConverter 이용하여 변환하면 됨!!
public class EmployerServiceImpl implements EmployerService {

    private final EmployeeRepository employeeRepository;
    private final JobPostRepository jobPostRepository;
    private final ApplicationRepository applicationRepository;
    private final EmployerRepository employerRepository;

    // 공고 등록
    @Override
    public boolean saveJobPost(Request_JobPostDto job_postingDto)
    {
        JobPost jobPost = new JobPost(employerRepository.findByUsername(job_postingDto.getEmployer_id()),
                job_postingDto.getEmployerCompname(), job_postingDto.getLocation(), job_postingDto.getSalaryPerTime(),
                job_postingDto.getWorkDate(), job_postingDto.getWorkTimeFrom(), job_postingDto.getWorkTimeTo());
        jobPostRepository.save(jobPost);
        return true;
    }

    // 작성한 공고글 리스트 반환
    @Override
    public List<Response_JobPostDto> getJobPosts(String username)
    {
        List<JobPost> jobPosts = jobPostRepository.findByEmployer(employerRepository.findByUsername(username));
        List<Response_JobPostDto> jobPostDtos = new ArrayList<>();
        for (JobPost jobPost : jobPosts) {
            jobPostDtos.add(DtoConverter.ToJobPostDto(jobPost));
        }
        return jobPostDtos;
    }

    //작성한 공고글 중 RECRUITING상태의 공고글 리스트 반환
    @Override
    public List<Response_JobPostDto> getJobPosts_RECRUITING(String username)
    {
        List<JobPost> jobPosts = jobPostRepository.findByEmployerAndJobPostState(employerRepository.findByUsername(username), JobPostState.RECRUITING);
        List<Response_JobPostDto> jobPostDtos = new ArrayList<>();
        for (JobPost jobPost : jobPosts) {
            jobPostDtos.add(DtoConverter.ToJobPostDto(jobPost));
        }
        return jobPostDtos;
    }

    //작성한 공고글 중 COMPLETED상태의 공고글 리스트 반환
    @Override
    public List<Response_JobPostDto> getJobPosts_COMPLETED(String username)
    {
        List<JobPost> jobPosts = jobPostRepository.findByEmployerAndJobPostState(employerRepository.findByUsername(username), JobPostState.COMPLETED);
        List<Response_JobPostDto> jobPostDtos = new ArrayList<>();
        for (JobPost jobPost : jobPosts) {
            jobPostDtos.add(DtoConverter.ToJobPostDto(jobPost));
        }
        return jobPostDtos;
    }

    // 공고글(jobPost_id)의 Application 리스트 반환(dto로)
    @Override
    public List<Response_ApplicationDto> getApplications(Long jobPost_id)
    {
        List<Application> applications = applicationRepository.findByJobPostId(jobPost_id);
        List<Response_ApplicationDto> applicationDtos = new ArrayList<>();
        for (Application application : applications) {
            applicationDtos.add(DtoConverter.ToApplicationDto(application));
        }
        return applicationDtos;
    }

    //지원서 상태 수락으로 변경 및 공고글 상태 완료로 변경
    @Override
    public boolean acceptApplication(Long jobPost_id, Long application_id)
    {
        Optional<JobPost> jobPost = jobPostRepository.findById(jobPost_id);
        Optional<Application> application = applicationRepository.findById(application_id);
        if (jobPost.isPresent() && application.isPresent()) {
            //JobPostState: RECRUITING-> COMPLETED, ApplicationState: WAITING->ACCEPT

            jobPost.get().completeRecruitment();
            application.get().accept();

        } else throw new JobPostNotFoundException("JobPost or Application not found");

        return true;
    }

    //공고글 삭제하기
    @Override
    public boolean deleteJobPost(Long jobPost_id) {
        Optional<JobPost> jobPost = jobPostRepository.findById(jobPost_id);
        if(jobPost.isPresent()) {
            jobPostRepository.delete(jobPost.get());
        } else throw new JobPostNotFoundException("JobPost not found");
        return true;
    }
}
