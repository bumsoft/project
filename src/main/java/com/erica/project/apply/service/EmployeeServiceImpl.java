package com.erica.project.apply.service;

import com.erica.project.User.repository.EmployeeRepository;
import com.erica.project.apply.domain.JobPost;
import com.erica.project.apply.dto.DtoConverter;
import com.erica.project.apply.dto.common.Response_JobPostDto;
import com.erica.project.apply.dto.employee.Response_PostwithApplicationDto;
import com.erica.project.apply.repository.ApplicationRepository;
import com.erica.project.apply.repository.JobPostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static com.erica.project.apply.dto.DtoConverter.ToJobPostDto;

@Service
@RequiredArgsConstructor
@Transactional
//Dto변환은 모두 DtoConverter에 만들어놨으니, DtoConverter이용하여 변환하면 됨!!
public class EmployeeServiceImpl implements EmployeeService {

    private final JobPostRepository jobPostRepository;
    private final ApplicationRepository applicationRepository;

    // 지역(String)을 받아서, 그 지역의 공고글 리스트(dto)를 반환하는 메서드
    // 추가로직 :JobPost의 state가 RECRUITING인 것만 반환
    @Override
    public List<Response_JobPostDto> getJobPostsByLocation(String location)
    {
        // db에서 location, state를 받아서 그 location을 포함하는 JobPost를 list로 반환(repository 활용)
        List<JobPost> jobPost = jobPostRepository.findByLocationAndState(location, "RECRUITING");

        // JobPost Entity를 Dto로 변환 - dtoconverter 활용
        return List.of(DtoConverter.ToJobPostDto(jobPost));
    }


    //공고글에 신청하는(지원서작성) 기능(Application생성후 저장) (username을 통해서, Employee객체를 얻고, 이걸 이용해 Application생성)
    @Override
    public boolean applyJobPost(Long jobPost_id, String username)
    {
        return false;
    }

    //username이 신청한 지원서 + 공고글이 합쳐진 dto리스트를 반환하는 메서드
    // DtoConverter.ToPostwithApplicationDto사용
    // 지원서는 리포에서 username이 작성한 지원서리스트 가져오면 됨
    @Override
    public List<Response_PostwithApplicationDto> getApplicationsByusername(String username)
    {
        return List.of();
    }

    //getApplicationsByusername와 같은기능이지만 로직이 추가됨
    // 추가로직 : 지원서의 상태가 ACCEPT인 것만 반환
    @Override
    public List<Response_PostwithApplicationDto> getApplicationsByusername_ACCEPT(String username)
    {
        return List.of();
    }

    //getApplicationsByusername와 같은 기능이지만 로직이 추가됨
    // 추가로직 : 공고글이 RECRUITING인 것만 반환
    @Override
    public List<Response_PostwithApplicationDto> getApplicationsByusername_RECRUITING(String username)
    {
        return List.of();
    }

    //지원서 삭제기능
    @Override
    public boolean deleteApplication(Long application_id)
    {
        return false;
    }
}
