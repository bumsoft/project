package com.erica.project.User.domain;

import com.erica.project.apply.domain.Job_Posting;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
public class Employer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Employer_autoID;

    @Column(nullable = false)
    private String Employer_name;

    @Column(unique=true, nullable=false)
    private String Employer_id;

    @Column(nullable = false)
    private String Employer_pw;

    @Column(unique=true)
    private String Employer_ph;

    @Column(unique=true)
    private String Employer_email;

    @Column(nullable = false)
    private String Employer_joindate;

    @Column(nullable = false)
    private String Employer_compname;

    @OneToMany
    private List<Job_Posting> Employer_recruitmentlist;

}
