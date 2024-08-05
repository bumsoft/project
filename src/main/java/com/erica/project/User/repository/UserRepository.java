package com.erica.project.User.repository;

import com.erica.project.User.domain_x.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
