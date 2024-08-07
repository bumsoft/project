package com.erica.project.apply.domain;

import com.erica.project.User.domain.Employer;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Getter
public class Job_Posting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Job_Posting_id;

    //작성자 외래키
    @ManyToOne
    private Employer Employer_id;

    //공고글에 딸린 지원서 리스트
    @OneToMany(mappedBy = "Job_Posting", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> Applications;

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
