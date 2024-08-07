package com.erica.project.User.service;

import com.erica.project.User.domain_x.Career;
import com.erica.project.User.domain_x.User;
import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.User.dto.EmployerRegisterDto;
import com.erica.project.User.repository.CareerRepository;
import com.erica.project.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final PasswordEncoder passwordEncoder;

    private final UserRepository userRepository;
    private final CareerRepository careerRepository;
    @Override
    public void joinEmployee(EmployeeRegisterDto employeeRegisterDto)
    {  // 알바생 회원가입
        User user = new User(employeeRegisterDto.getUserId(), passwordEncoder.encode(employeeRegisterDto.getPassword())
                , employeeRegisterDto.getUserName(),
                employeeRegisterDto.getPhoneNumber(), employeeRegisterDto.getUserRole());

         joinCareer(employeeRegisterDto.getCareerList(), userRepository.save(user));
    }

    @Override
    public void joinEmployer(EmployerRegisterDto employerRegisterDto)
    { // 사장님 회원가입
        User user = new User(employerRegisterDto.getUserId(), passwordEncoder.encode(employerRegisterDto.getPassword()),employerRegisterDto.getUserName(),
                employerRegisterDto.getPhoneNumber(), employerRegisterDto.getUserRole());

        userRepository.save(user);
    }

    @Override
    public void joinCareer(List<Career> careerList, User user)
    {
        for(Career career : careerList)
        {
            career.setUser(user);
            careerRepository.save(career);
        }
    }
}
