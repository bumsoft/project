package com.erica.project.User.repository;

import com.erica.project.User.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    // Employee 엔티티에 특화된 쿼리 정의

    Optional<Employee> findById(Long id);

    Optional<Employee> findByUsername(String username);

    // 회원탈퇴.삭제 로직
    static void deleteEmployeeByUserId(Long id) {

    }

}