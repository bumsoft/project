package com.erica.project.User.domain;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.Set;

@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("employee")
// JPA 어노테이션으로, 이 엔티티가 User 테이블에 저장될 때 user_type 컬럼의 값으로 "EMPLOYEE"를 사용하도록 지정합니다.
public class Employee extends User{

    @Column(nullable = false)
    private String Employee_addr;

    @Column(nullable = false)
    private String Employee_workarea;

    @Column(nullable = false)
    private String Employee_career;

    @Column(nullable = false)
    private Employee_Level Employee_level;

    @Column(nullable = false)
    @ElementCollection(targetClass = Employee_Brand.class)
    private Set<Employee_Brand> Employee_brand;

}
