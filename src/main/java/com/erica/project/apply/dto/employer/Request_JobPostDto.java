package com.erica.project.apply.dto.employer;

import com.erica.project.User.domain.Employer;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.sql.Time;

@Getter
@Setter
public class Request_JobPostDto {

    private Employer employer;

    //가게이름
    private String employerCompname;

    //시급
    private int salaryPerTime;

    //지역
    private String location;

    //날짜
    private Date workDate;

    //시작시간
    private Time workTimeFrom;

    //종료시간
    private Time workTimeTo;

}
