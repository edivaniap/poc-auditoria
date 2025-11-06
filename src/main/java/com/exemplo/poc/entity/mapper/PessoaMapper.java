package com.exemplo.poc.entity.mapper;

import com.exemplo.poc.domain.Pessoa;
import com.exemplo.poc.entity.PessoaEntity;
import org.springframework.stereotype.Component;

@Component
public class PessoaMapper implements EntityMapper<Pessoa, PessoaEntity> {


    @Override
    public Pessoa toDomain(PessoaEntity entity) {
        return null;
    }

    @Override
    public PessoaEntity toEntity(Pessoa domain) {
        return null;
    }

}
