package com.erica.project.apply.domain;

import lombok.Getter;

@Getter
public enum JobPostState {
    RECRUITING("RECRUITING"),
    COMPLETED("COMPLETED");
    private String value;

    private JobPostState(String value)
    {
        this.value = value;
    }
}
