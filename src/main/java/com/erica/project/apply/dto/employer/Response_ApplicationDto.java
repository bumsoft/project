package com.erica.project.apply.dto.employer;

import com.erica.project.User.domain.Employee_Level;
import com.erica.project.apply.domain.ApplicationState;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Response_ApplicationDto {

    private Long application_id;

    //유저정보 start
    private String name;

    private String employeeCareer;

    private Employee_Level employeeLevel;
    //end

    private String applyDate;

    private ApplicationState applicationState;
}
