package com.erica.project.User.service;

import com.erica.project.User.domain.Employee;
import com.erica.project.User.domain.Employer;
import com.erica.project.User.domain.UserRole;
import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.User.dto.EmployerRegisterDto;
import com.erica.project.User.dto.UserRegisterDto;
import com.erica.project.User.exception.UserAlreadyExistException;
import com.erica.project.User.repository.EmployeeRepository;
import com.erica.project.User.repository.EmployerRepository;
import com.erica.project.User.repository.UserRepository;
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
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public Employee employeeRegister(EmployeeRegisterDto employeeRegisterDto) throws UserAlreadyExistException
    {
        //중복회원 등 확인하는 부분 추가
        if(idCheck(employeeRegisterDto.getUsername())) //아이디가 있다면
        {
            throw new UserAlreadyExistException("이미 존재하는 아이디");
        }

        employeeRegisterDto.setRole(UserRole.EMPLOYEE);

        String encodePW = passwordEncoder.encode(employeeRegisterDto.getPw());
        employeeRegisterDto.setPw(encodePW);
        Employee employee = new Employee(employeeRegisterDto);
        return employeeRepository.save(employee);
    }

    @Override
    public Employer employerRegister(EmployerRegisterDto employerRegisterDto) throws UserAlreadyExistException
    {
        //중복회원 등 확인하는 부분 추가
        if(idCheck(employerRegisterDto.getUsername())) //아이디가 있다면
        {
            throw new UserAlreadyExistException("이미 존재하는 아이디");
        }

        employerRegisterDto.setRole(UserRole.EMPLOYER);

        String encodePW = passwordEncoder.encode(employerRegisterDto.getPw());
        employerRegisterDto.setPw(encodePW);
        Employer employer = new Employer(employerRegisterDto);
        return employerRepository.save(employer);
    }

    //중복아이디확인 메서드
    @Override
    public boolean idCheck(String id)
    {
        return userRepository.existsByusername(id);
    }
}
