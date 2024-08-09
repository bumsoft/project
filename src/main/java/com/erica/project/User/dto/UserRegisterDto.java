package com.erica.project.User.dto;

import com.erica.project.User.domain.UserRole;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDto {

    @NotEmpty(message="이름을 입력하세요.")
    private String name;

    @NotEmpty(message="아이디를 입력하세요.")
    private String id;

    @NotEmpty(message="비밀번호를 입력하세요.")
    private String pw;

    @NotEmpty(message="전화번호를 입력하세요.")
    private String ph;

    @NotEmpty(message="이메일을 입력하세요.")
    private String email;

    private UserRole role;
}
