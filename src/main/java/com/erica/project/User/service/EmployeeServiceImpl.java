package com.erica.project.User.service;


import com.erica.project.User.domain.Employee;
import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.User.repository.EmployeeRepository;
import com.erica.project.User.repository.JobPostingRepository;
import com.erica.project.User.repository.UserRepository;
import com.erica.project.apply.domain.Job_Posting;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final UserRepository userRepository;
    private final JobPostingRepository jobPostingRepository;


    @Override
    public List<Job_Posting> getAllJobPostings() {
        return jobPostingRepository.findAll();
    }

    @Override
    public List<Job_Posting> searchJobPostingByKeyword(String Keyword) {
        return jobPostingRepository.findbyKeyword(Keyword);
    }

    @Override
    public Job_Posting applyForJob(Long jobId, Long userId) {
        return null;
    }

    @Override
    public List<Job_Posting> getJobPostingsByDate(LocalDate date) {
        return jobPostingRepository.findByDate(date);
    }

    @Override
    public List<EmployeeRegisterDto> getApplicationStatus(Long userId) { // 지원 현황 조회
        return List.of();
    }

    @Override
    public List<Job_Posting> getApplicationsByUser(Long userId) { // 지원한 공고 리스트 조회
        Employee employee = employeeRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return jobPostingRepository.findByEmployee(userId);
    }
}
