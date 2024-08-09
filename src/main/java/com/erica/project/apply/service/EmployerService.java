package com.erica.project.apply.service;
import com.erica.project.apply.domain.*;
import com.erica.project.User.domain.Employee;
import com.erica.project.apply.dto.Job_PostingDto;

import java.util.List;

public interface EmployerService {
    // 공고 등록
    Job_Posting saveJobPost(Job_PostingDto job_postingDto);



    // 공고에 대한 지원자 목록 조회
    List<Application> getApplicationList(int Job_Posting_id);


    // 지원자 정보 조회
    Employee getApplicantsInfo (int Employee_id);

    // 지원현황 업데이트

    // 지원서 상태변경 : 대기중 -> 수락
    Application applicationAC()


    // 숙련도 입력 (초급, 중급, 고급)
    Employee giveEmployeeLevel(int Employee_id);
}