package com.erica.project.apply.controller;

import com.erica.project.apply.domain.JobPost;
import com.erica.project.apply.dto.common.Response_JobPostDto;
import com.erica.project.apply.service.EmployeeService;
import com.erica.project.apply.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ApplyController {

    private final EmployerService employerService;
    private final EmployeeService employeeService;


}
