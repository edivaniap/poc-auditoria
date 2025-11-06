package com.exemplo.poc.repository.jpa;

import com.exemplo.poc.entity.EstudanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstudanteJpaRepository extends JpaRepository<EstudanteEntity, Long> {
}