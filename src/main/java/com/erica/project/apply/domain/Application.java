package com.erica.project.apply.domain;

import com.erica.project.User.domain.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
@RequiredArgsConstructor
public class Application {

    public Application(JobPost jobPost, Employee employee)
    {
        this.jobPost = jobPost;
        this.employee = employee;
        applicationState = ApplicationState.WAITING;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long application_id;

    //공고글 외래키
    @ManyToOne
    private JobPost jobPost;

    //지원자 외래키
    @ManyToOne
    private Employee employee;

    @CreatedDate
    private String applyDate;

    @Enumerated(EnumType.STRING)
    private ApplicationState applicationState;

}
