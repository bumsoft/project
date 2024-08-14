package com.erica.project.User.service;

import com.erica.project.User.domain.Employee;
import com.erica.project.User.domain.Employer;
import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.User.dto.EmployerRegisterDto;
import com.erica.project.exception.UserAlreadyExistException;

public interface UserRegisterService {

    Employee employeeRegister(EmployeeRegisterDto employeeRegisterDto) throws UserAlreadyExistException;

    Employer employerRegister(EmployerRegisterDto employerRegisterDto) throws UserAlreadyExistException;

    boolean idCheck(String id);
}
