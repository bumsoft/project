package com.erica.project.User.controller;

import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.User.dto.EmployerRegisterDto;
import com.erica.project.exception.UserAlreadyExistException;
import com.erica.project.User.service.UserDeleteService;
import com.erica.project.User.service.UserRegisterService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserRegisterService userRegisterService;
    private final UserDeleteService userDeleteService; // 필드주입 or 생성자 주입..>

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
    public String registerEmployer(@Valid EmployerRegisterDto employerRegisterDto, BindingResult bindingResult)
    {
        //유효성 검사
        if (bindingResult.hasErrors())
        {
            return "User/registerEmployer";
        }


        //저장로직 추가
        try {
            userRegisterService.employerRegister(employerRegisterDto);
        }catch (UserAlreadyExistException e) {
            e.printStackTrace();
            bindingResult.reject("Duplicate.employer","이미 존재하는 아이디");
            return "User/registerEmployer";
        }catch(Exception e){
            e.printStackTrace();
            bindingResult.reject("error","기타 에러");
            return "User/registerEmployer";
        }

        return "redirect:/login";
    }

    @PostMapping("register/employee")
    public String registerEmployee(@Valid EmployeeRegisterDto employeeRegisterDto, BindingResult bindingResult)
    {
        //유효성 검사
        if (bindingResult.hasErrors())
        {
            return "User/registerEmployee";
        }
        try {
            //저장로직 추가
            userRegisterService.employeeRegister(employeeRegisterDto);
        }catch(UserAlreadyExistException e){
            e.printStackTrace();
            bindingResult.reject("Duplicate.employee", "이미 존재하는 아이디" );
            return "User/registerEmployee";
        }catch(Exception e){
            e.printStackTrace();
            bindingResult.reject("error","기타 에러");
            return "User/registerEmployee";
        }

        return "redirect:/login";
    }

// 회원 탈퇴 -- template html 만들어야 함 UserPage.html에 회원탈퇴 바튼 추가 후 클릭하면 삭제시키는 동작
// +탈퇴시 로그아웃 진행되게 추가하기
    @DeleteMapping("/user/delete/id")
    public String deleteUser(@PathVariable Long id){
        userDeleteService.deleteUser(id);
        return "redirect:/logout";
    }


// 회원 정보 수정할 때

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
