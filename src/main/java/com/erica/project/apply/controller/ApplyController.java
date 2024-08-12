package com.erica.project.apply.controller;

import com.erica.project.apply.dto.Request_Location;
import com.erica.project.apply.dto.common.Response_JobPostDto;
import com.erica.project.apply.dto.employer.Request_JobPostDto;
import com.erica.project.apply.service.EmployeeService;
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


    ////////////////////////사장기능///////////////////////////////
    //사장 메인페이지
    @GetMapping("employer")
    public String employer(Model model)
    {
        return "Apply/employerMainPage";
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
        System.out.println("hellowo");

        form.setEmployer_id(principal.getName());
        System.out.println("hellowo");
        employerService.saveJobPost(form);
        return "redirect:/employer";
    }


    /////////////////////////알바기능////////////////////////////////
    @GetMapping("employee")
    public String employee(Model model)
    {

        List<Response_JobPostDto> allJobPosts = employeeService.getAllJobPosts();
        model.addAttribute("alljobPosts", allJobPosts);
        model.addAttribute("search", new Request_Location());


        return "Apply/employeeMainPage";
    }

    @PostMapping("employee/search")
    public String employeeSearch(Request_Location location, Model model)
    {

        List<Response_JobPostDto> allJobPosts = employeeService.getAllJobPosts();
        model.addAttribute("alljobPosts", allJobPosts);

        List<Response_JobPostDto> list = employeeService.getJobPostsByLocation(location.getLocation());
        model.addAttribute("jobPosts", list);
        model.addAttribute("search", new Request_Location());


        return "Apply/employeeMainPage";
    }
}
