package com.erica.project.User.service;

import com.erica.project.User.domain.User;
import com.erica.project.User.dto.UserRegisterDto;
import com.erica.project.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class UserUpdateService {

// repository 사용해서 Entity 가져옴 - 수정할 정보: 휴대폰번호, 비밀번호,

    @Autowired
    private UserRepository userRepository;

    public User getUserPh(Long id){
        return userRepository.
    }

}
