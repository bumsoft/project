package com.erica.project.apply.controller;

import com.erica.project.apply.dto.employee.Response_PostwithApplicationDto;
import com.erica.project.apply.dto.employer.Response_ApplicationDto;
import com.erica.project.exception.AlreadyApplyException;
import com.erica.project.exception.UserNotFoundException;
import com.erica.project.apply.dto.Request_Location;
import com.erica.project.apply.dto.common.Response_JobPostDto;
import com.erica.project.apply.dto.employer.Request_JobPostDto;
import com.erica.project.apply.service.EmployeeService;
import com.erica.project.apply.service.EmployeeServiceImpl;
import com.erica.project.apply.service.EmployerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class ApplyController {

    private final EmployerService employerService;
    private final EmployeeService employeeService;
    private final EmployeeServiceImpl employeeServiceImpl;


    ////////////////////////사장기능///////////////////////////////
    //사장 메인페이지
    @GetMapping("employer")
    public String employer(Model model,Principal principal)
    {
        //모든 작성 공고
        List<Response_JobPostDto> alljobPosts = employerService.getJobPosts(principal.getName());
        model.addAttribute("alljobPosts", alljobPosts);

        //모집중인 공고
        List<Response_JobPostDto> jobPostsRecruiting = employerService.getJobPosts_RECRUITING(principal.getName());
        model.addAttribute("recruitingjobPosts", jobPostsRecruiting);

        //모집완료된 공고
        List<Response_JobPostDto> jobPostsCompleted = employerService.getJobPosts_COMPLETED(principal.getName());
        model.addAttribute("completedjobPosts", jobPostsCompleted);

        return "Apply/employerMainPage";
    }

    @GetMapping("employer/delete/{id}")
    public String deleteJobPost(@PathVariable("id") Long id, Model model, Principal principal)
    {
        employerService.deleteJobPost(id);

        return "redirect:/employer";
    }

    @GetMapping("employer/jobPost/details/{jobPost_id}")
    public String detailJobPost(@PathVariable("jobPost_id") Long id, Model model, Principal principal)
    {
        //모든 지원자
        List<Response_ApplicationDto> applications = employerService.getApplications(id);
        model.addAttribute("allapplications", applications);

        //승인된 지원자
        List<Response_ApplicationDto> acceptedApplications = employerService.getAcceptedApplications(id);
        model.addAttribute("acceptedApplications", acceptedApplications);

        model.addAttribute("jobPostId", id);

        return "Apply/jobPostDetail";
    }

    //승인
    @GetMapping("employer/jobPost/details/{jobPost_id}/accept/{application_id}")
    public String acceptApplication(@PathVariable("jobPost_id") Long jobPostId, @PathVariable("application_id") Long applicationId, Model model, Principal principal)
    {
        employerService.acceptApplication(jobPostId, applicationId);
        return "redirect:/employer/jobPost/details/"+jobPostId;
    }


    @GetMapping("employer/newJobPost")
    public String newJobPost(Model model)
    {
        model.addAttribute("form", new Request_JobPostDto());
        return "Apply/newJobPostForm";
    }
    @PostMapping("employer/newJobPost")
    public String newJobPost(@Valid Request_JobPostDto form, BindingResult bindingResult, Model model, Principal principal)
    {

        if (bindingResult.hasErrors())
        {
            bindingResult.getAllErrors().forEach(error -> System.out.println(error.getDefaultMessage()));
            return "Apply/newJobPostForm";
        }

        form.setEmployer_id(principal.getName());
        employerService.saveJobPost(form);
        return "redirect:/employer";
    }


    /////////////////////////알바기능////////////////////////////////
    @GetMapping("employee")
    public String employee(Model model,Principal principal)
    {

        List<Response_JobPostDto> allJobPosts = employeeService.getAllJobPosts();
        model.addAttribute("alljobPosts", allJobPosts);
        model.addAttribute("search", new Request_Location());

        List<Response_PostwithApplicationDto> applyJobPosts = employeeService.getApplicationsByusername(principal.getName());
        model.addAttribute("applyJobPosts", applyJobPosts);


        return "Apply/employeeMainPage";
    }

    @PostMapping("employee/search")
    public String employeeSearch(Request_Location location, Model model, Principal principal)
    {

        List<Response_JobPostDto> list = employeeService.getJobPostsByLocation(location.getLocation(), principal.getName());
        model.addAttribute("jobPosts", list);
        model.addAttribute("search", new Request_Location());
        model.addAttribute("location",location.getLocation());

        List<Response_PostwithApplicationDto> applyJobPosts = employeeService.getApplicationsByusername(principal.getName());
        model.addAttribute("applyJobPosts", applyJobPosts);

        return "Apply/employeeMainPageSearch";
    }

    @GetMapping("employee/apply/{jobPost_id}")
    public String employeeApply(@PathVariable("jobPost_id") Long jobPost_id, Model model, Principal principal)
    {
        try
        {
            employeeService.applyJobPost(jobPost_id, principal.getName());
        } catch (AlreadyApplyException | UserNotFoundException e)
        {
            //bindingResult.rejectValue(e.getMessage(),e.getMessage());
            return "redirect:/employee";
        }
        return "redirect:/employee";
    }

    @GetMapping("employee/apply/cancel/{application_id}")
    public String employeeApplyCancel(@PathVariable("application_id") Long application_id, Model model, Principal principal)
    {
        System.out.println("hello");
        try
        {
            employeeService.deleteApplication(application_id);
        }catch(Exception e){
            //예외처리
            return "redirect:/employee";
        }
        return "redirect:/employee";
    }
}
