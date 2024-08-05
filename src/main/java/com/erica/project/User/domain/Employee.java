package com.erica.project.User.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Entity
@Getter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Employee_autoID;

    @Column(nullable = false)
    private String Employee_name;

    @Column(unique=true, nullable=false)
    private String Employee_id;

    @Column(nullable = false)
    private String Employee_pw;

    @Column(unique=true, nullable=false)
    private String Employee_ph;

    @Column(unique=true)
    private String Employee_email;

    @Column(nullable = false)
    private String Employee_joindate;

    //@Column(nullable = false)
    private String Employee_addr;

    private String Employee_workarea;

    private String Employee_career;

    private Employee_Level Employee_level;

    @ElementCollection(targetClass = Employee_Brand.class)
    private Set<Employee_Brand> Employee_brand;

}
