package com.erica.project.User.service;

import com.erica.project.User.domain.Employee;
import com.erica.project.User.domain.Employer;
import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.User.dto.EmployerRegisterDto;
import com.erica.project.User.dto.UserRegisterDto;
import com.erica.project.User.repository.EmployeeRepository;
import com.erica.project.User.repository.EmployerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class UserRegisterServiceImpl implements UserRegisterService {

    private final EmployeeRepository employeeRepository;
    private final EmployerRepository employerRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void employeeRegister(EmployeeRegisterDto employeeRegisterDto)
    {
        String encodePW = passwordEncoder.encode(employeeRegisterDto.getPw());
        employeeRegisterDto.setPw(encodePW);
        Employee employee = new Employee(employeeRegisterDto);
        employeeRepository.save(employee);
    }

    @Override
    public void employerRegister(EmployerRegisterDto employerRegisterDto)
    {
        String encodePW = passwordEncoder.encode(employerRegisterDto.getPw());
        employerRegisterDto.setPw(encodePW);
        Employer employer = new Employer(employerRegisterDto);
        employerRepository.save(employer);
    }
}
