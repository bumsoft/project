package com.erica.project.User.repository;

import com.erica.project.User.domain_x.Userx;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Userx, Long> {
    // 공통 쿼리 정의
}
