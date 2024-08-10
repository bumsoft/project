package com.erica.project.User.repository;

import com.erica.project.User.domain.Employee;
import com.erica.project.User.domain.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployerRepository extends JpaRepository<Employer, Long> {
    // Employer 엔티티에 특화된 쿼리 메서드를 정의

    // 회원탈퇴. 삭제 로직
    static void deleteEmployerByUserId(Long id) {

    }


    Employer findByUsername(String username);
}