package com.erica.project.User.service;

import com.erica.project.User.repository.EmployeeRepository;
import com.erica.project.User.repository.EmployerRepository;
import com.erica.project.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserDeleteService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployerRepository employerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void deleteUser(Long userId) {

        // Employee 삭제
        //EmployeeRepository.deleteEmployeeByUserId(userId);

        // Employer 삭제
        //EmployerRepository.deleteEmployerByUserId(userId);

        // User 삭제
        UserRepository.deleteByautoID(userId);
    }
}
