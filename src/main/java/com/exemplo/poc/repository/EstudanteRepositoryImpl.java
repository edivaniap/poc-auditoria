package com.exemplo.poc.repository;

import com.exemplo.poc.domain.Estudante;
import com.exemplo.poc.entity.EstudanteEntity;
import com.exemplo.poc.entity.mapper.EstudanteMapper;
import com.exemplo.poc.repository.jpa.EstudanteJpaRepository;

public class EstudanteRepositoryImpl extends BaseRepositoryImpl<Estudante, EstudanteEntity, Long>
        implements BaseRepository<Estudante, Long> {

    public EstudanteRepositoryImpl(EstudanteJpaRepository jpaRepository, EstudanteMapper mapper) {
        super(jpaRepository, mapper);
    }

}