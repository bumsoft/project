package com.erica.project.User.dto;

import com.erica.project.User.domain.UserRole;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {

    @NotEmpty(message="재설정할 비밀번호를 입력하세요.")
    private String pw;

    @NotEmpty(message="수정할 전화번호를 입력하세요.")
    private String ph;

    @NotEmpty(message="수정할 이메일을 입력하세요.")
    private String email;

    private UserRole role;
}
