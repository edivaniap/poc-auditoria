package com.exemplo.poc.service;

import com.exemplo.poc.domain.Estudante;
import com.exemplo.poc.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class EstudanteServiceImpl extends BaseServiceImpl<Estudante, Long> {

    public EstudanteServiceImpl(BaseRepository<Estudante, Long> repository) {
        super(repository);
    }

}
