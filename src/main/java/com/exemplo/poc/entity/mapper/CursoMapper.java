package com.exemplo.poc.entity.mapper;

import com.exemplo.poc.domain.Curso;
import com.exemplo.poc.entity.CursoEntity;
import org.springframework.stereotype.Component;

@Component
public class CursoMapper implements EntityMapper<Curso, CursoEntity> {

    @Override
    public Curso toDomain(CursoEntity entity) {
        return null;
    }

    @Override
    public CursoEntity toEntity(Curso domain) {
        return null;
    }

}
