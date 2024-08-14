package com.erica.project.User.service;

import com.erica.project.User.domain.User;
import com.erica.project.User.dto.UserDbDto;
import com.erica.project.exception.UserNotFoundException;
import com.erica.project.User.repository.UserRepository;
import lombok.RequiredArgsConstructor;

import java.util.Optional;

@RequiredArgsConstructor
public class UserUpdateService {

    // repository 사용해서 Entity 가져옴 - 수정할 정보: 휴대폰번호, 비밀번호,

    private final UserRepository userRepository;

    // 비밀번호 수정
    public void updatePw(UserDbDto userDbDto) throws UserNotFoundException {
        // dto로 일단 가져와.
        Optional<User> _user = userRepository.findByusername(userDbDto.getId());
        if(_user.isEmpty()){
            // 예외처리
            throw new UserNotFoundException("user is not found.");
        }
        User user = _user.get();
        user.setPassword(userDbDto.getPw()); //
        userRepository.save(user);
    }

    // 전화번호 수정
    public void updatePh(UserDbDto userDbDto) throws UserNotFoundException {
        Optional<User> _user = userRepository.findByusername(userDbDto.getId());
        if(_user.isEmpty()){
            // 예외처리
            throw new UserNotFoundException("user is not found.");
        }
        User user = _user.get();
        user.setPhoneNumber(userDbDto.getPh()); //
        userRepository.save(user); //
    }

}
