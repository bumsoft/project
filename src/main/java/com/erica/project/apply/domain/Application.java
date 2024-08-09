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

    public Application(Job_Posting job_posting, Employee employee)
    {
        this.job_posting = job_posting;
        this.employee = employee;
        Application_state = Application_State.WAITING;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Application_id;

    //공고글 외래키
    @ManyToOne
    private Job_Posting job_posting;

    //지원자 외래키
    @ManyToOne
    private Employee employee;

    @CreatedDate
    private String Application_date;

    @Enumerated
    private Application_State Application_state;

}
