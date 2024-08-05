package com.erica.project.User.dto;

import com.erica.project.User.domain_x.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployerRegisterDto {
    private String userId;
    private String password;
    private String userName;
    private String phoneNumber;

    private UserRole userRole = UserRole.ROLE_EMPLOYEE;
}
