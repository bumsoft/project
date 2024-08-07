package com.erica.project.User.dto;

import com.erica.project.User.domain.BrandName;
import com.erica.project.User.domain.Employee_Level;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Setter
@Getter
public class EmployeeRegisterDto extends UserRegisterDto {


    private String employeeAddr;

    private String employeeWorkarea;

    private String employeeCareer;

   private Employee_Level  EmployeeLevel = Employee_Level.LEVEL1;

   // @Setter
   // private Set<BrandName> Employee_brands;


    @Override
    public String toString()
    {
        return super.toString() +
                "employeeAddr='" + employeeAddr + '\'' +
                ", employeeWorkarea='" + employeeWorkarea + '\'' +
                ", employeeCareer='" + employeeCareer + '\'' +
                '}';
    }
}
