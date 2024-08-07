package com.erica.project.User.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRegisterDto {

    private String name;

    private String id;

    private String pw;

    private String ph;

    private String email;

    @Override
    public String toString()
    {
        return "UserRegisterDto{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", pw='" + pw + '\'' +
                ", ph='" + ph + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
