package com.erica.project.User.repository;

import com.erica.project.User.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 유저 삭제시, Employer리포 또는Employee리포에서 삭제한 뒤, User리포에서 한번 더 삭제해줘야댐
 *
 *
 */
public interface UserRepository extends JpaRepository<User, Long> {
    // 공통 쿼리 정의
    // 중복 id 확인
    boolean existsByid(String id);

    // User 회원탈퇴. 삭제
    static void deleteUserByUserId(Long id) {

    }

    // 회원정보 수정
}
