package com.erica.project.apply.service;

import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.apply.domain.Job_Posting;
import com.erica.project.apply.dto.Job_PostingDto;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

public interface EmployeeService {

    //


    //공고글 리스트 조회
    List<Job_Posting> getAllJobPostings();

    // 공고 검색 - 검색 방법 1. 키워드로 검색/ 2. 지도에서 검색
    List<Job_PostingDto> searchJobPostingByKeyword(String Keyword);


    // 공고보고 지원,
    Job_Posting applyForJob(Long jobId, String userId);

    // 근무날짜로 공고 검색,
    List<Job_Posting> getJobPostingsByDate(LocalDate date);

    // user의 지원 현황 조회
    List<EmployeeRegisterDto> getApplicationStatus(Long userId);


    // user가 신청한 공고글 리스트 조회
    List<Job_Posting> getApplicationsByUser(Long userId);

    //특정 공고에 대한 승인된 지원자 리스트 조회
    //List<EmployeeRegisterDto> getApprovedApplicants(Long jobId);


}
