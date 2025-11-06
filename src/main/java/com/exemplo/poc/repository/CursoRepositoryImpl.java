package com.exemplo.poc.repository;

import com.exemplo.poc.domain.Curso;
import com.exemplo.poc.entity.CursoEntity;
import com.exemplo.poc.entity.mapper.CursoMapper;
import com.exemplo.poc.repository.jpa.CursoJpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CursoRepositoryImpl extends BaseRepositoryImpl<Curso, CursoEntity, Long>
        implements BaseRepository<Curso, Long> {

    public CursoRepositoryImpl(CursoJpaRepository jpaRepository, CursoMapper mapper) {
        super(jpaRepository, mapper);
    }

}