package com.erica.project.User.dto;

import com.erica.project.User.domain.User;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SecondaryRow;

@Getter
@Setter
public class UserDbDto  {

    private String id;
    private String pw;
    private String ph;
    private String email;

    public UserDbDto(UserRegisterDto userRegisterDto) {
        this.id = userRegisterDto.getUsername();
        this.pw = userRegisterDto.getPw();
        this.ph = userRegisterDto.getPh();
        this.email = userRegisterDto.getEmail();
    }
}
