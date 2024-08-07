package com.erica.project.User.domain;

import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.User.dto.UserRegisterDto;
import com.erica.project.apply.domain.Application;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Set;

@Getter
@RequiredArgsConstructor
@Entity
@DiscriminatorValue("EMPLOYEE")
// JPA 어노테이션으로, 이 엔티티가 User.java 테이블에 저장될 때 user_type 컬럼의 값으로 "EMPLOYEE"를 사용하도록 지정합니다.
public class Employee extends User{

    public Employee(EmployeeRegisterDto employeeRegisterDto)
    {
        super(employeeRegisterDto);
        this.Employee_addr = employeeRegisterDto.getEmployeeAddr();
        this.Employee_workarea = employeeRegisterDto.getEmployeeWorkarea();
        this.Employee_career = employeeRegisterDto.getEmployeeCareer();
        this.Employee_level = employeeRegisterDto.getEmployeeLevel();
       // this.Employee_brand = employeeRegisterDto.getEmployee_brands();
    }

    //집주소
    @Column(nullable = false)
    private String Employee_addr;

    //일하는곳 주소?
    @Column(nullable = false)
    private String Employee_workarea;

    //경력부분
    @Column(nullable = false)
    private String Employee_career;

    //숙련도. 기본 level1로 일단은
    @Column(nullable = false)
    private Employee_Level Employee_level;

    @Column(nullable = false)
    @ElementCollection(targetClass = BrandName.class)
    @Enumerated(EnumType.STRING) //enum이름을 문자열형태로 저장
    @CollectionTable(name="Employe_Brand") //컬렉션을 저장할 테이블의 이름
    private Set<BrandName> Employee_brand;

    //지원한 지원서 리스트
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true) //
    private List<Application> applications;

}
