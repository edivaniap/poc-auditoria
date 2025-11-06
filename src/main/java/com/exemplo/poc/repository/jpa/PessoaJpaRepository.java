package com.exemplo.poc.repository.jpa;

import com.exemplo.poc.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaJpaRepository extends JpaRepository<PessoaEntity, Long> {
}