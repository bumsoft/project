package com.erica.project.apply.service;
import com.erica.project.apply.dto.common.Response_JobPostDto;
import com.erica.project.apply.dto.employer.Request_JobPostDto;
import com.erica.project.apply.dto.employer.Response_ApplicationDto;

import java.util.List;

//Dto변환은 모두 DtoConverter에 만들어놨으니, DtoConverter이용하여 변환하면 됨!!
public interface EmployerService {

    // 공고 등록
    boolean saveJobPost(Request_JobPostDto job_postingDto);

    // 작성한 공고글 리스트 반환
    List<Response_JobPostDto> getJobPosts(String username);

    //작성한 공고글 중 RECRUITING상태의 공고글 리스트 반환
    List<Response_JobPostDto> getJobPosts_RECRUITING(String username);

    //작성한 공고글 중 COMPLETED상태의 공고글 리스트 반환
    List<Response_JobPostDto> getJobPosts_COMPLETED(String username);

    // 공고글(jobPost_id)의 Application 리스트 반환(dto로)
    List<Response_ApplicationDto> getApplications(Long jobPost_id);

    // 공고글(jobPost_id)의 승인된 Application 리스트 반환(dto로)
    List<Response_ApplicationDto> getAcceptedApplications(Long jobPost_id);

    //지원서 상태 수락으로 변경 및 공고글 상태 완료로 변경
    boolean acceptApplication(Long jobPost_id, Long application_id);

    //공고글 삭제하기
    boolean deleteJobPost(Long jobPost_id);
}