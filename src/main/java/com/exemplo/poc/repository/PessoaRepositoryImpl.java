package com.exemplo.poc.repository;

import com.exemplo.poc.domain.Pessoa;
import com.exemplo.poc.entity.PessoaEntity;
import com.exemplo.poc.entity.mapper.PessoaMapper;
import com.exemplo.poc.repository.jpa.PessoaJpaRepository;

public class PessoaRepositoryImpl extends BaseRepositoryImpl<Pessoa, PessoaEntity, Long>
        implements BaseRepository<Pessoa, Long> {

    public PessoaRepositoryImpl(PessoaJpaRepository jpaRepository, PessoaMapper mapper) {
        super(jpaRepository, mapper);
    }

}