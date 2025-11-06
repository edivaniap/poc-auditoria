package com.exemplo.poc.entity.mapper;

import com.exemplo.poc.domain.Estudante;
import com.exemplo.poc.entity.EstudanteEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class EstudanteMapper implements EntityMapper<Estudante, EstudanteEntity> {

    private final PessoaMapper pessoaMapper;
    private final CursoMapper cursoMapper;

    @Override
    public Estudante toDomain(EstudanteEntity entity) {
        return null;
    }

    @Override
    public EstudanteEntity toEntity(Estudante domain) {
        return null;
    }

}
