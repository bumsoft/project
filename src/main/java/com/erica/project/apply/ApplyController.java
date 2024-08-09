package com.erica.project.apply;

import com.erica.project.apply.domain.Job_Posting;
import com.erica.project.apply.dto.Job_PostingDto;
import com.erica.project.apply.service.EmployeeService;
import com.erica.project.apply.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ApplyController {

    private final EmployerService employerService;
    private final EmployeeService employeeService;

    //지역검색
    @GetMapping("employee/list/{keyword}")
    public String employerPosting(@PathVariable String keyword, Model model)
    {
        List<Job_PostingDto> jobPostings = employeeService.searchJobPostingByKeyword(keyword);

    }

    //지원기능
    @GetMapping("employee/jobpost/{id}/apply")
    public String apply(@PathVariable Long id, Principal principal)
    {
        String userId = principal.getName();//사용자 id
        employeeService.applyForJob(id, userId); //job post의 id와 유저 아이디를 받아서 application생성

        return null;
    }
}
