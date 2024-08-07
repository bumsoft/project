package com.erica.project.User.service;
import com.erica.project.apply.domain.*;
import com.erica.project.User.domain.Employee;

import java.util.List;

public interface EmployerService {
    // 공고 등록,
    <JobPosting> Job_Posting registerJobPost(JobPosting jobPosting);

    // 공고에 대한 지원자 목록 조회,
    List<Employee> getApplicants(int Job_Posting_id);

    // 지원자 정보 조회,
    Employee getApplicantsInfo (int Employee_id);

    // 지원현황 업데이트

    // 알바생 지원에 대한 수락/거절,
    Application_State AcceptOrReject(int Application_id, boolean accept);

    // 숙련도 입력 (초급, 중급, 고급)
    Employee giveEmployeeLevel(int Employee_id);
}