package com.erica.project.apply.domain;

import com.erica.project.User.domain.Employer;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Date;
import java.sql.Time;
import java.util.List;

@Entity
@Getter
@RequiredArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class JobPost {

    /**
     *
     * @param employer
     * @param employerCompname
     * @param location
     * @param salaryPerTime
     * @param workDate
     * @param workTimeFrom
     * @param workTimeTo
     */
    public JobPost(Employer employer, String employerCompname, String location, int salaryPerTime, Date workDate, Time workTimeFrom, Time workTimeTo)
    {
        this.employer = employer;
        this.employerCompname = employerCompname;
        this.location = location;
        this.salaryPerTime = salaryPerTime;
        this.workDate = workDate;
        this.workTimeFrom = workTimeFrom;
        this.workTimeTo = workTimeTo;
        this.jobPostState = JobPostState.RECRUITING;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long jobPost_id;

    //작성자 외래키
    @ManyToOne
    private Employer employer;

    //공고글에 딸린 지원서 리스트
    @OneToMany(mappedBy = "jobPost", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Application> applications;

    @Column(nullable = false)
    private String employerCompname;

    @Column(nullable = false)
    private String location; //일단 임시로 쓸 지역

    @Column(nullable = false)
    private int salaryPerTime;

    @Column(nullable = false)
    private Date workDate;

    @Column(nullable = false)
    private Time workTimeFrom;

    @Column(nullable = false)
    private Time workTimeTo;

    @CreatedDate
    private String postDate;

    @Enumerated(EnumType.STRING)
    private JobPostState jobPostState;

    // 상태를 변경하는 메서드 추가
    public void completeRecruitment() {
        if (this.jobPostState == JobPostState.RECRUITING) {
            this.jobPostState = JobPostState.COMPLETED;
        } else {
            throw new IllegalStateException("JobPost is not in a recruiting state");
        }
    }



}
