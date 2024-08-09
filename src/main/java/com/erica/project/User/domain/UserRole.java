package com.erica.project.User.domain;

import lombok.Getter;

@Getter
public enum UserRole {
    ADMIN("ROLE_ADMIN"),
    EMPLOYEE("ROLE_EMPLOYEE"),
    EMPLOYER("ROLE_EMPLOYER");

    private String value;

    UserRole(String value)
    {
        this.value = value;
    }
}
