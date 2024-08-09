package com.erica.project.apply.service;


import com.erica.project.User.domain.Employee;
import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.User.repository.EmployeeRepository;
import com.erica.project.User.repository.UserRepository;
import com.erica.project.apply.domain.Application;
import com.erica.project.apply.domain.Job_Posting;
import com.erica.project.apply.dto.Job_PostingDto;
import com.erica.project.apply.repository.ApplicationRepository;
import com.erica.project.apply.repository.Job_PostingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    private final Job_PostingRepository jobPostingRepository;
    private final ApplicationRepository applicationRepository;


    @Override
    public List<Job_Posting> getAllJobPostings()
    {
        return jobPostingRepository.findAll();
    }

    @Override
    public List<Job_PostingDto> searchJobPostingByKeyword(String Keyword)
    {
        List<Job_Posting> list = jobPostingRepository.findByLocation(Keyword);
        //위 리스트를 Job_PostingDto 리스트로 변환하기
    }

    @Override
    public Job_Posting applyForJob(Long jobId, Long userId)
    {
        Optional<Job_Posting> job = jobPostingRepository.findById(jobId);
        if(job.isEmpty())
        {
            //예외천국
        }
        Job_Posting jobPosting = job.get();

                Employee employee = this.employeeRepository.findById(userId);
        Application application = new Application(jobPosting,employee);

        applicationRepository.save(application);

    }

    @Override
    public List<Job_Posting> getJobPostingsByDate(LocalDate date)
    {
        return jobPostingRepository.findByDate(date);
    }

    @Override
    public List<EmployeeRegisterDto> getApplicationStatus(Long userId)
    { // 지원 현황 조회
        return List.of();
    }

    @Override
    public List<Job_Posting> getApplicationsByUser(Long userId)
    { // 지원한 공고 리스트 조회
        Employee employee = employeeRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return jobPostingRepository.findByEmployee(userId);
    }



}
