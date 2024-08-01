package com.erica.project.User;

import com.erica.project.User.domain.Career;
import com.erica.project.User.dto.EmployeeRegisterDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @GetMapping("register/employer")
    public String registerEmployer()
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
        List<Career> careerList =employeeRegisterDto.getCareerList();
        System.out.println(employeeRegisterDto.getUserName());


        return "User/userPage";
    }
    @GetMapping("/login")
    public String login()
    {
        return "User/loginForm";
    }


}
