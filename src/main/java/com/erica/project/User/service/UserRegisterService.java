package com.erica.project.User.service;

import com.erica.project.User.domain.User;
import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.User.dto.EmployerRegisterDto;
import com.erica.project.User.dto.UserRegisterDto;

public interface UserRegisterService {

    void employeeRegister(EmployeeRegisterDto employeeRegisterDto);

    void employerRegister(EmployerRegisterDto employerRegisterDto);
}
