package com.erica.project.apply.repository;

import com.erica.project.apply.domain.Application;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationRepository extends JpaRepository<Application, Long> {


}
