package com.erica.project.User.service;

import com.erica.project.User.repository.EmployeeRepository;
import com.erica.project.User.repository.EmployerRepository;
import com.erica.project.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserDeleteService {

    private final UserRepository userRepository;

    private final EmployerRepository employerRepository;

    private final EmployeeRepository employeeRepository;

    @Transactional
    public void deleteUser(Long user_id) {

        // Employee 삭제
        //EmployeeRepository.deleteEmployeeByUserId(userId);

        // Employer 삭제
        //EmployerRepository.deleteEmployerByUserId(userId);

        // User 삭제
        userRepository.deleteById(user_id);
    }
}