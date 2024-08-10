package com.erica.project.apply.repository;

import com.erica.project.apply.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ApplicationRepository extends JpaRepository<Application, Long> {

    static Optional<Application> findByusername(String username){};

}
