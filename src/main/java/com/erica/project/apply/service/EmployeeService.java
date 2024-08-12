package com.erica.project.apply.service;

import com.erica.project.User.exception.ApplicationNotFoundException;
import com.erica.project.User.exception.UserNotFoundException;
import com.erica.project.apply.domain.Application;
import com.erica.project.apply.domain.JobPost;
import com.erica.project.apply.dto.employee.Response_PostwithApplicationDto;
import com.erica.project.apply.dto.common.Response_JobPostDto;

import java.util.List;


//Dto변환은 모두 DtoConverter에 만들어놨으니, DtoConverter이용하여 변환하면 됨!!
public interface EmployeeService {

    //지역(String)을 받아서, 그 지역의 공고글 리스트(dto)를 반환하는 메서드
    // 추가로직 :JobPost의 state가 RECRUITING인 것만 반환
    List<Response_JobPostDto> getJobPostsByLocation(String location);

    //공고글에 신청하는(지원서작성) 기능(Application생성후 저장) (username을 통해서, Employee객체를 얻고, 이걸 이용해 Application생성)
    Application applyJobPost(Long jobPost_id, String username) throws UserNotFoundException;

    //username이 신청한 지원서 + 공고글이 합쳐진 dto리스트를 반환하는 메서드
    // DtoConverter.ToPostwithApplicationDto사용
    // 지원서는 리포에서 username이 작성한 지원서리스트 가져오면 됨
    List<Response_PostwithApplicationDto> getApplicationsByusername(String username);


    //getApplicationsByusername와 같은기능이지만 로직이 추가됨
    // 추가로직 : 지원서의 상태가 ACCEPT인 것만 반환
    List<Response_PostwithApplicationDto> getApplicationsByusername_ACCEPT(String username);

    //getApplicationsByusername와 같은 기능이지만 로직이 추가됨
    // 추가로직 : 공고글이 RECRUITING인 것만 반환
    List<Response_PostwithApplicationDto> getApplicationsByusername_RECRUITING(String username);

    //지원서 삭제기능
    boolean deleteApplication(Long application_id) throws ApplicationNotFoundException;


}