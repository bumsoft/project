package com.erica.project.apply.dto.common;

import com.erica.project.apply.domain.JobPostState;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class Response_JobPostDto {

    private Long jobPost_id;

    private String employerCompname;

    private String location;

    private int salaryPerTime;

    private Date workDate;

    private Time workTimeFrom;

    private Time workTimeTo;

    private String postDate;

    private JobPostState jobPostState;

}
