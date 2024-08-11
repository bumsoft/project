package com.erica.project.apply.service;

import com.erica.project.User.domain.Employee;
import com.erica.project.User.exception.UserNotFoundException;
import com.erica.project.User.repository.EmployeeRepository;
import com.erica.project.User.repository.EmployerRepository;
import com.erica.project.apply.domain.Application;
import com.erica.project.apply.domain.JobPost;
import com.erica.project.apply.domain.JobPostState;
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
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
//Dto변환은 모두 DtoConverter에 만들어놨으니, DtoConverter이용하여 변환하면 됨!!
public class EmployeeServiceImpl implements EmployeeService {

    private final JobPostRepository jobPostRepository;
    private final ApplicationRepository applicationRepository;
    private final EmployerRepository employerRepository;
    private final EmployeeRepository employeeRepository;

    // 지역(String)을 받아서, 그 지역의 공고글 리스트(dto)를 반환하는 메서드
    // 추가로직 :JobPost의 state가 RECRUITING인 것만 반환
    @Override
    public List<Response_JobPostDto> getJobPostsByLocation(String location)
    {
        // db에서 location, state를 받아서 그 location을 포함하는 JobPost를 list로 반환(repository 활용)
        List<JobPost> jobPosts = jobPostRepository.findByLocationAndJobPostState(location, JobPostState.RECRUITING);
        List<Response_JobPostDto> jobPostDtos = new ArrayList<>();
        for (JobPost jobPost : jobPosts)
        {
            jobPostDtos.add(DtoConverter.ToJobPostDto(jobPost));
        }
        return jobPostDtos;

        //stream사용시 아래코드.  성능차이는 거의 없어서 익숙한 반복문으로 처리함
//        List<Response_JobPostDto> jobPostDtos = jobPostRepository.findByLocationAndState(location, JobPostState.RECRUITING.getValue())
//                .stream()
//                .map(DtoConverter::ToJobPostDto)
//                .toList();
//        return jobPostDtos;
    }


    //공고글에 신청하는(지원서작성) 기능(Application생성후 저장)
    // (username을 통해서, Employee객체를 얻고, 이걸 이용해 Application생성)
    @Override
    public Application applyJobPost(Long jobPost_id, String username) throws UserNotFoundException {

        // jobPost_id로 db에서 JobPost 객체 넘겨받기
        Optional<JobPost> jobPostOpt = jobPostRepository.findById(jobPost_id);
        JobPost jobPost = jobPostOpt.orElseThrow(()-> new UserNotFoundException("User not found"));

        // username으로 db에서 Employee 객체 넘겨받기
        Optional<Employee> employeeOpt = Optional.ofNullable(employeeRepository.findByUsername(username));
        Employee employee = employeeOpt.orElseThrow(()-> new UserNotFoundException("User not found"));

        // Application 생성, 저장
        Application application = new Application(jobPost, employee);
        applicationRepository.save(application);

        return application;

    }


    // username이 신청한 지원서 + 공고글이 합쳐진 dto리스트를 반환하는 메서드
    // DtoConverter.ToPostwithApplicationDto사용
    // 지원서는 리포에서 username이 작성한 지원서리스트 가져오면 됨
    @Override
    public List<Response_PostwithApplicationDto> getApplicationsByusername(String username)
    {
        // username이 작성한 지원서 갖고오기
        List<Application> application = ApplicationRepository.findByUsername(username);

        // 지원서 리스트를 순회하면서 dto로 변환하고 리스트에 추가
        List<Response_PostwithApplicationDto> applicationDtos = new ArrayList<>();
        for (Application application1 : application){
            applicationDtos.add(DtoConverter.ToPostwithApplicationDto(application1));
        }

        return applicationDtos;
    }


    //getApplicationsByusername와 같은기능이지만 로직이 추가됨
    // 추가로직 : 지원서의 상태가 ACCEPT인 것만 반환
    @Override
    public List<Response_PostwithApplicationDto> getApplicationsByusername_ACCEPT(String username)
    {
        List<Application> application = ApplicationRepository.findByUsername(username);

        // 가져온 application 중에서 지원서의 상태가 Accept인 것만 필터링
        List<Response_PostwithApplicationDto> application_accepted = application.stream()
                .filter(application -> "ACCPETED".equals(application.getApplicationState()))
                .collect(Collectors.toList());

        return application_accepted;
    }

    //getApplicationsByusername와 같은 기능이지만 로직이 추가됨
    // 추가로직 : 공고글이 RECRUITING인 것만 반환
    @Override
    public List<Response_PostwithApplicationDto> getApplicationsByusername_RECRUITING(String username)
    {
        // username 가져오고
        List<Application> application = ApplicationRepository.findByUsername(username);
        // 공고글이 recruiting인 것들 필터링
        List<Response_PostwithApplicationDto> application_jobpost_recruiting = application.stream()
                .filter(application -> "RECRUTING".equals(application.getJobPost().getJobPostState()))
                .collect(Collectors.toList());

        return List.of();
    }

    //지원서 삭제기능
    @Override
    public boolean deleteApplication(Long application_id)
    {
        // application_id를 받아서 db에서 삭제
        Optional<Application> applicationOpt = applicationRepository.findById(application_id);
        if(applicationOpt.isEmpty()){
            return false;
        }
        applicationRepository.delete(applicationOpt.get());
        return true;
    }
}
