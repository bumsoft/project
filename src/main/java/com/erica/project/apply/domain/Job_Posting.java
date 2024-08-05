package com.erica.project.apply.domain;

import com.erica.project.User.domain.Employer;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.sql.Time;

@Entity
@Getter
public class Job_Posting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Job_Posting_id;

    @ManyToOne
    private Employer Employer_id;

    @Column(nullable = false)
    private String Employer_compname;

    @Column(nullable = false)
    private String Job_Posting_salaryPerTime;

    @Column(nullable = false)
    private Date Job_Posting_workdate;

    @Column(nullable = false)
    private Time Job_Posting_worktime;

    @CreatedDate
    private String Job_Postdate;
}
