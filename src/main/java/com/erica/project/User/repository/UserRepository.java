package com.erica.project.User.repository;

import com.erica.project.User.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * UserRepo에서만 삭제해줘도 되네
 *
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    // 공통 쿼리 정의
    // 중복 id 확인
    boolean existsByid(String id);

    // User 회원탈퇴. 삭제
    void deleteByautoID(Long autoId);


    // 회원정보 수정

    //회원조회(로그인시)
    Optional<User> findByid(String id);
}
