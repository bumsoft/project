package com.erica.project.User.repository;

import com.erica.project.User.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Employee 엔티티에 특화된 쿼리 정의
}