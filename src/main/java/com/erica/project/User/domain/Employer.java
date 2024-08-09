package com.erica.project.User.domain;

import com.erica.project.User.dto.EmployerRegisterDto;
import com.erica.project.apply.domain.JobPost;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor // 생성자 자동생성
@Entity
@DiscriminatorValue("EMPLOYER")
@Getter
public class Employer extends User {

    public Employer(EmployerRegisterDto employerRegisterDto)
    {
        super(employerRegisterDto);
        this.employerCompName = employerRegisterDto.getEmployerCompname();
    }
    //가게이름 ex. CU oo점
    @Column(nullable = false)
    private String employerCompName;


    //사장이 작성한 공고글 리스트
    @OneToMany(mappedBy = "employer", cascade = CascadeType.ALL, orphanRemoval = true) //사장삭제시 공고글도 삭제됨
    private List<JobPost> employerPostList;

}
