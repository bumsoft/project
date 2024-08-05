package com.erica.project.User.dto;

import com.erica.project.User.domain_x.Career;
import com.erica.project.User.domain_x.UserRole;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class EmployeeRegisterDto {

    private String userId;
    private String password;
    private String userName;
    private String phoneNumber;

    private UserRole userRole = UserRole.ROLE_EMPLOYER;

    private List<Career> careerList;
}
