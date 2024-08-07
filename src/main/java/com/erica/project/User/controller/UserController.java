package com.erica.project.User.controller;

import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.User.dto.EmployerRegisterDto;
import com.erica.project.User.dto.UserRegisterDto;
import com.erica.project.User.repository.EmployerRepository;
import com.erica.project.User.service.UserRegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserRegisterService userRegisterService;
    //private final EmployerRepository employerRepository;

    @GetMapping("register/employer")
    public String registerEmployer(Model model)
    {
        model.addAttribute("employerRegisterDto", new EmployerRegisterDto());
        return "User/registerEmployer";
    }

    @GetMapping("register/employee")
    public String registerEmployee(Model model)
    {
        model.addAttribute("employeeRegisterDto", new EmployeeRegisterDto());
        return "User/registerEmployee";
    }

    @PostMapping("register/employer")
    public String registerEmployer(@Valid EmployerRegisterDto employerRegisterDto)
    {
        //유효성 검사

        //저장로직 추가
        userRegisterService.employerRegister(employerRegisterDto);

        return "User/userPage";
    }

    @PostMapping("register/employee")
    public String registerEmployee(@Valid EmployeeRegisterDto employeeRegisterDto)
    {
        //유효성 검사

        //저장로직 추가
        userRegisterService.employeeRegister(employeeRegisterDto);

        return "User/userPage";
    }






//    @PostMapping("register/employer")
//    public String registerEmployer(EmployerRegisterDto employerRegisterDto, Model model)
//    {
//        userService.joinEmployer(employerRegisterDto);
//
//        return "User/userPage";
//    }



    @GetMapping("/login")
    public String login()
    {
        return "User/loginForm";
    }


}
