package com.erica.project.apply.controller;

import com.erica.project.apply.service.EmployeeService;
import com.erica.project.apply.service.EmployerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

//@Controller
@RequiredArgsConstructor
public class ApplyController {

    private final EmployerService employerService;
    private final EmployeeService employeeService;


}
