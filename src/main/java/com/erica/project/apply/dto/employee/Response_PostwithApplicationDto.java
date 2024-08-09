package com.erica.project.apply.dto.employee;

import com.erica.project.apply.domain.ApplicationState;
import com.erica.project.apply.domain.JobPostState;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

//공고글 + 지원서(상태 지원일 등)
@Getter
@Setter
public class Response_PostwithApplicationDto {

    private Long jobPost_id;

    private String employerCompname;

    private String location;

    private int salaryPerTime;

    private Date workDate;

    private Time workTimeFrom;

    private Time workTimeTo;

    private String postDate;

    private JobPostState jobPostState;
    ///////////////////////////////
    private Long application_id;

    private String applyDate;

    private ApplicationState applicationState;

}
