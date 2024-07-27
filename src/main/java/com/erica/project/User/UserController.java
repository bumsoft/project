package com.erica.project.User;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

    @GetMapping("register/employer")
    public String registerEmployer()
    {
        return "User/registerEmployer";
    }

    @GetMapping("register/employee")
    public String registerEmployee()
    {
        return "User/registerEmployee";
    }

    @GetMapping("/login")
    public String login()
    {
        return "User/loginForm";
    }


}
