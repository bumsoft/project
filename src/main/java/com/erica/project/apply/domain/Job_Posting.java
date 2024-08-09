package com.erica.project.apply.domain;

import com.erica.project.User.domain.Employer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
public class Job_Posting {


    public Job_Posting(Employer employer, String employer_compname, String location, String job_Posting_salaryPerTime, Date job_Posting_workdate, Time job_Posting_worktime)
    {
        this.employer = employer;
        Employer_compname = employer_compname;
        Job_Posting_salaryPerTime = job_Posting_salaryPerTime;
        this.location = location;
        Job_Posting_workdate = job_Posting_workdate;
        Job_Posting_worktime = job_Posting_worktime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Job_Posting_id;

    //작성자 외래키
    @ManyToOne
    private Employer employer;

    //공고글에 딸린 지원서 리스트
    @OneToMany(mappedBy = "job_posting", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> Applications;

    @Column(nullable = false)
    private String Employer_compname;

    @Column(nullable = false)
    private String location; //일단 임시로 쓸 지역

    @Column(nullable = false)
    private String Job_Posting_salaryPerTime;

    @Column(nullable = false)
    private Date Job_Posting_workdate;

    @Column(nullable = false)
    private Time Job_Posting_worktime;

    @CreatedDate
    private String Job_Postdate;
}
