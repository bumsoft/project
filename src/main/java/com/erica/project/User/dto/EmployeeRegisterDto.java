package com.erica.project.User.dto;

import com.erica.project.User.domain.BrandName;
import com.erica.project.User.domain.Employee_Level;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class EmployeeRegisterDto extends UserRegisterDto {

    @NotEmpty(message="주소를 입력하세요.")
    private String employeeAddr;

    @NotEmpty(message="희망 근무지역을 입력하세요.")
    private String employeeWorkarea;

    @NotEmpty(message="경력 입력하세요.")
    private String employeeCareer;

   private Employee_Level  EmployeeLevel = Employee_Level.LEVEL1;

   // @Setter
   // private Set<BrandName> Employee_brands;

}
