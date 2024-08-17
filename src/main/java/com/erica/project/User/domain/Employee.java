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

        this.total_score = 0;
        this.div_num = 0;

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

    //////////////LEVEL부분////////////////////
    //숙련도. 기본 level0으로 시작로 일단은      //
    @Column(nullable = false)               //
    private Employee_Level employeeLevel;   //
    //숙련도 총합                             //
    @Column(nullable = false)               //
    private int total_score;                //
    //숙련도 참여자 수                         //
    @Column(nullable = false)               //
    private int div_num;                        //
    //////////////////////////////////////////


    @Column(nullable = false)
    @ElementCollection(targetClass = BrandName.class)
    @Enumerated(EnumType.STRING) //enum이름을 문자열형태로 저장
    @CollectionTable(name="Employe_Brand") //컬렉션을 저장할 테이블의 이름
    private Set<BrandName> employeeBrand;

    //지원한 지원서 리스트
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true) //
    private List<Application> applications;

    public void updateLevel(int score)
    {
        div_num++;
        total_score += score;

        switch(total_score/div_num)
        {
            case 1:employeeLevel=Employee_Level.LEVEL1; break;
            case 2:employeeLevel=Employee_Level.LEVEL2;break;
            case 3:employeeLevel=Employee_Level.LEVEL3;break;
            case 4:employeeLevel=Employee_Level.LEVEL4;break;
            case 5:employeeLevel=Employee_Level.LEVEL5;break;
            case 6:employeeLevel=Employee_Level.LEVEL6;break;
            case 7:employeeLevel=Employee_Level.LEVEL7;break;
            case 8:employeeLevel=Employee_Level.LEVEL8;break;
            case 9:employeeLevel=Employee_Level.LEVEL9;break;
            case 10:employeeLevel=Employee_Level.LEVEL10;break;
        }
    }

}
