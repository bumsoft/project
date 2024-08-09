package com.erica.project.User.service;

import com.erica.project.User.domain.User;
import com.erica.project.User.dto.UserRegisterDto;
import com.erica.project.User.dto.UserUpdateDto;
import com.erica.project.User.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class UserUpdateService {

// repository 사용해서 Entity 가져옴 - 수정할 정보: 휴대폰번호, 비밀번호,

    @Autowired
    private UserRepository userRepository;

    // 비밀번호 수정
    public void updatePw(UserRegisterDto userRegisterDto) {
        // dto로 일단 가져와.
        Optional<User> _user = userRepository.findByid(userRegisterDto.getId());
        if(_user.isEmpty()){
            // 예외처리
        }
        User user = _user.get();
        user.setPw(UserUpdateDto.getPw()); //
        userRepository.save(user);
    }

    // 전화번호 수정
    public void updatePh(UserRegisterDto userRegisterDto) {
        Optional<User> _user = userRepository.findByid(userRegisterDto.getId());
        if(_user.isEmpty()){
            // 예외처리
        }
        User user = _user.get();
        user.setPh(UserUpdateDto.getPh()); //
        userRepository.save(user);
    }

}
