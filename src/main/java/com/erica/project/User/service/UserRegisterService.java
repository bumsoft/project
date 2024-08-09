package com.erica.project.User.service;

import com.erica.project.User.domain.User;
import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.User.dto.EmployerRegisterDto;
import com.erica.project.User.dto.UserRegisterDto;
import com.erica.project.User.exception.UserAlreadyExistException;

public interface UserRegisterService {

    void employeeRegister(EmployeeRegisterDto employeeRegisterDto) throws UserAlreadyExistException;

    void employerRegister(EmployerRegisterDto employerRegisterDto) throws UserAlreadyExistException;

    boolean idCheck(String id);
}
