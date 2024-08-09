package com.erica.project.apply.dto;

import com.erica.project.User.domain.Employer;
import com.erica.project.apply.domain.Application;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Getter
@Setter
public class Job_PostingDto {

    private Employer employer;

    //가게이름
    private String Employer_compname;

    //시급
    private String Job_Posting_salaryPerTime;

    //지역
    private String location;

    //날짜
    private Date Job_Posting_workdate;

    //시간
    private Time Job_Posting_worktime;

}
