package com.exemplo.poc.service;

import com.exemplo.poc.domain.Pessoa;
import com.exemplo.poc.repository.BaseRepository;
import org.springframework.stereotype.Service;

@Service
public class PessoaServiceImpl extends BaseServiceImpl<Pessoa, Long> {

    public PessoaServiceImpl(BaseRepository<Pessoa, Long> repository) {
        super(repository);
    }

}
