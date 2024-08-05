package com.erica.project.User.controller;

import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.User.dto.EmployerRegisterDto;
import com.erica.project.User.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;

    @GetMapping("register/employer")
    public String registerEmployer(EmployerRegisterDto employerRegisterDto)
    {
        return "User/registerEmployer";
    }

    @GetMapping("register/employee")
    public String registerEmployee(Model model)
    {
        EmployeeRegisterDto employeeRegisterDto = new EmployeeRegisterDto();
        employeeRegisterDto.setCareerList(new ArrayList<>());
        model.addAttribute("employeeRegisterDto", employeeRegisterDto);
        return "User/registerEmployee";
    }

    @PostMapping("register/employee")
    public String registerEmployee(EmployeeRegisterDto employeeRegisterDto, Model model)
    {
        userService.joinEmployee(employeeRegisterDto);

        return "User/userPage";
    }

    @PostMapping("register/employer")
    public String registerEmployer(EmployerRegisterDto employerRegisterDto, Model model)
    {
        userService.joinEmployer(employerRegisterDto);

        return "User/userPage";
    }

    @GetMapping("/login")
    public String login()
    {
        return "User/loginForm";
    }


}
