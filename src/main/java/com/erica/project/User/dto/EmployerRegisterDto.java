package com.erica.project.User.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployerRegisterDto extends UserRegisterDto{
    private String employerCompname;
}
