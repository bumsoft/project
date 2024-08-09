package com.erica.project.User.service;

import com.erica.project.User.repository.EmployeeRepository;
import com.erica.project.User.repository.EmployerRepository;
import com.erica.project.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class UserDeleteService {

    private UserRepository userRepository;

    @Transactional
    public void deleteUser(Long userId) {
        userRepository.deleteByautoID(userId);
    }
}
