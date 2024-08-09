package com.erica.project.User.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployerRegisterDto extends UserRegisterDto{

    @NotEmpty(message="가게명 입력하세요.")
    private String employerCompname;
}
