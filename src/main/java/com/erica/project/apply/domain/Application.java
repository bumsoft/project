package com.erica.project.apply.domain;

import com.erica.project.User.domain.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Getter
public class Application {

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
