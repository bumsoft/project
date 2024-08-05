package com.erica.project.User.domain_x;

//경력

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String brandName;

    private Long workingMonths;

    @ManyToOne
    private User user;

}
