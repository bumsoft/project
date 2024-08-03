package com.erica.project.User.service;

import com.erica.project.User.domain.Career;
import com.erica.project.User.domain.User;
import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.User.dto.EmployerRegisterDto;

import java.util.List;

public interface UserService {

    public void joinEmployee(EmployeeRegisterDto employeeRegisterDto);

    public void joinEmployer(EmployerRegisterDto employerRegisterDto);

    public void joinCareer(List<Career> careerList, User user);

}
