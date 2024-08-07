package com.erica.project.User.domain;

import com.erica.project.apply.domain.Job_Posting;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor // 생성자 자동생성
@Entity
@DiscriminatorValue("EMPLOYER")
public class Employer extends User {

    @Column(nullable = false)
    private String Employer_compname;

    @Column(nullable = false)
    @OneToMany
    private List<Job_Posting> Employer_recruitmentlist;

}
