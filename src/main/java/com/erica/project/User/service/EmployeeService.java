package com.erica.project.User.service;

import com.erica.project.apply.domain.Job_Posting;

import java.util.List;

public interface EmployeeService {
    // 공고 검색 - 검색 방법 1. 키워드로 검색/ 2. 지도에서 검색
    List<Job_Posting> searchJobPost(String Keywords);

    // 공고 상세보기

    // 공고보고 지원,

    // 근무날짜검색,

    // 지원 현황 확인
}
