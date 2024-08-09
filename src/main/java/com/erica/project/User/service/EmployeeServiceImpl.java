package com.erica.project.User.service;


import com.erica.project.User.domain.Employee;
import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.User.repository.EmployeeRepository;
import com.erica.project.User.repository.JobPostingRepository;
import com.erica.project.User.repository.UserRepository;
import com.erica.project.apply.domain.Job_Posting;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.data.jpa.domain.Specification;

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

    @Override // 공고 제목, 공고 내용, 공고 작성자 -> kw 존재?
    public Specification<Job_Posting> searchJobPostingByKeyword(String Kw) {
        return new Specification<Job_Posting>() {
            @Override
            public Predicate toPredicate(Root<Job_Posting> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                query.distinct(true); // 중복 제거
                return null;
            }

            private static final long serialVersionUID = 1L;

        };
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
