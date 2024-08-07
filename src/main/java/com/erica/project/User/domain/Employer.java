package com.erica.project.User.domain;

import com.erica.project.User.dto.EmployerRegisterDto;
import com.erica.project.User.dto.UserRegisterDto;
import com.erica.project.User.repository.UserRepository;
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

    public Employer(EmployerRegisterDto employerRegisterDto)
    {
        super(employerRegisterDto);
        this.Employer_compname = employerRegisterDto.getEmployerCompname();
    }
    //가게이름 ex. CU oo점
    @Column(nullable = false)
    private String Employer_compname;


    //사장이 작성한 공고글 리스트
    @OneToMany(mappedBy = "Employer", cascade = CascadeType.ALL, orphanRemoval = true) //사장삭제시 공고글도 삭제됨
    private List<Job_Posting> Employer_recruitmentlist;

}
