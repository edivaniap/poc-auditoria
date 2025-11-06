package com.exemplo.poc.repository.jpa;

import com.exemplo.poc.entity.CursoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CursoJpaRepository extends JpaRepository<CursoEntity, Long> {
}