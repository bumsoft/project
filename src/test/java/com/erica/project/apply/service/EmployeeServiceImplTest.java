package com.erica.project.apply.service;

import com.erica.project.User.domain.Employee;
import com.erica.project.User.domain.Employee_Level;
import com.erica.project.User.domain.Employer;
import com.erica.project.User.domain.UserRole;
import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.User.dto.EmployerRegisterDto;
import com.erica.project.exception.ApplicationNotFoundException;
import com.erica.project.exception.UserAlreadyExistException;
import com.erica.project.exception.UserNotFoundException;
import com.erica.project.User.repository.EmployeeRepository;
import com.erica.project.User.service.UserRegisterService;
import com.erica.project.apply.domain.Application;
import com.erica.project.apply.domain.JobPost;
import com.erica.project.apply.dto.common.Response_JobPostDto;
import com.erica.project.apply.repository.JobPostRepository;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@SpringBootTest
@Transactional
class EmployeeServiceImplTest {

    @Autowired
    private UserRegisterService userRegisterService;

    @Autowired
    private EmployeeService employeeService;

    Employee employee;
    Employer employer;
    JobPost jobPost1;
    JobPost jobPost2;
    JobPost jobPost3;
    @Autowired
    private JobPostRepository jobPostRepository;
    @Autowired
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() throws UserAlreadyExistException
    {

        //Employee 생성
        EmployeeRegisterDto employeeRegisterDto = new EmployeeRegisterDto();
        employeeRegisterDto.setName("알바");
        employeeRegisterDto.setUsername("alba");
        employeeRegisterDto.setPw("1");
        employeeRegisterDto.setEmail("alba@gmail.com");
        employeeRegisterDto.setPh("010-");
        employeeRegisterDto.setRole(UserRole.EMPLOYEE);

        employeeRegisterDto.setEmployeeAddr("주소");
        employeeRegisterDto.setEmployeeWorkarea("근무지");
        employeeRegisterDto.setEmployeeCareer("경력~~~");
        employeeRegisterDto.setEmployeeLevel(Employee_Level.LEVEL1);

         employee = userRegisterService.employeeRegister(employeeRegisterDto);


        //Employer 생성
        EmployerRegisterDto employerRegisterDto = new EmployerRegisterDto();
        employerRegisterDto.setName("사장");
        employerRegisterDto.setUsername("sajang");
        employerRegisterDto.setPw("1");
        employerRegisterDto.setEmail("sajang@gmail.com");
        employerRegisterDto.setPh("010-3");
        employerRegisterDto.setRole(UserRole.EMPLOYER);

        employerRegisterDto.setEmployerCompname("CU oo점");

         employer = userRegisterService.employerRegister(employerRegisterDto);

        //공고 생성

         jobPost1 = new JobPost(employer, employer.getEmployerCompName(), "안산시", 9900,
                Date.valueOf("2024-08-08"), Time.valueOf("10:30:00"), Time.valueOf("18:30:00") );
         jobPost2 = new JobPost(employer, employer.getEmployerCompName(), "안산시", 10500,
                Date.valueOf("2024-08-09"), Time.valueOf("06:00:00"), Time.valueOf("12:00:00") );
         jobPost3 = new JobPost(employer, employer.getEmployerCompName(), "과천시", 11000,
                Date.valueOf("2024-08-10"), Time.valueOf("16:00:00"), Time.valueOf("20:00:00") );

         jobPostRepository.save(jobPost1);
         jobPostRepository.save(jobPost2);
         jobPostRepository.save(jobPost3);

    }

    @Test
    void getJobPostsByLocation() throws UserAlreadyExistException
    {
        //given

        //when
        List<Response_JobPostDto> lis = employeeService.getJobPostsByLocation("안산시");

        //then
        int cnt = 2;
        System.out.println("hello");
        System.out.println(lis.size());
        for(Response_JobPostDto jb : lis)
        {
            System.out.println(jb.getLocation());
            System.out.println(jb.getSalaryPerTime());
            System.out.println("\n");

        }
    }

    @Test
    void 지원하기() throws UserNotFoundException, ApplicationNotFoundException
    {
        Application application = employeeService.applyJobPost(jobPost1.getJobPostId(), employee.getUsername());

        Application application_get = employeeService.getApplication(application.getApplication_id());

        org.assertj.core.api.Assertions.assertThat(application_get).isEqualTo(application);
    }

}