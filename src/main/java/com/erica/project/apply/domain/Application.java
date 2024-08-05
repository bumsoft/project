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

    @ManyToOne
    private Job_Posting Job_Posting_id;

    @ManyToOne
    private Employee Employee_id;

    @CreatedDate
    private String Application_date;

    @Enumerated
    private Application_State Application_state;


}
