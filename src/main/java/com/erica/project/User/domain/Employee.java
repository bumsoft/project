package com.erica.project.User.domain;

import com.erica.project.User.dto.EmployeeRegisterDto;
import com.erica.project.apply.domain.Application;
import jakarta.persistence.*;
import lombok.Getter;
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
        this.employeeAddr = employeeRegisterDto.getEmployeeAddr();
        this.employeeWorkArea = employeeRegisterDto.getEmployeeWorkarea();
        this.employeeCareer = employeeRegisterDto.getEmployeeCareer();
        this.employeeLevel = employeeRegisterDto.getEmployeeLevel();
       // this.Employee_brand = employeeRegisterDto.getEmployee_brands();
    }

    //집주소
    @Column(nullable = false)
    private String employeeAddr;

    //일하는곳 주소?
    @Column(nullable = false)
    private String employeeWorkArea;

    //경력부분
    @Column(nullable = false)
    private String employeeCareer;

    //숙련도. 기본 level1로 일단은
    @Column(nullable = false)
    private Employee_Level employeeLevel;

    @Column(nullable = false)
    @ElementCollection(targetClass = BrandName.class)
    @Enumerated(EnumType.STRING) //enum이름을 문자열형태로 저장
    @CollectionTable(name="Employe_Brand") //컬렉션을 저장할 테이블의 이름
    private Set<BrandName> employeeBrand;

    //지원한 지원서 리스트
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true) //
    private List<Application> applications;

}
