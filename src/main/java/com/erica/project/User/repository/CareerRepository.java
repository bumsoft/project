package com.erica.project.User.repository;

import com.erica.project.User.domain.Career;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CareerRepository extends JpaRepository<Career, Long> {
}
