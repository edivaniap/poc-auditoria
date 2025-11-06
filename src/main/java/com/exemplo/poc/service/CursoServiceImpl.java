package com.exemplo.poc.service;

import com.exemplo.poc.domain.Curso;
import com.exemplo.poc.repository.BaseRepository;

public class CursoServiceImpl extends BaseServiceImpl<Curso, Long> {

    public CursoServiceImpl(BaseRepository<Curso, Long> repository) {
        super(repository);
    }

}
