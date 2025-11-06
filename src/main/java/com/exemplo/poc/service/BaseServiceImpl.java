package com.exemplo.poc.service;

import com.exemplo.poc.repository.BaseRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseServiceImpl<D, ID> implements BaseService<D, ID> {

    protected final BaseRepository<D, ID> repository;

    @Transactional
    public D save(D domain) {
        return repository.save(domain);
    }

    @Transactional
    public D update(ID id, D domain) {
        if (!repository.existsById(id)) {
            throw new IllegalArgumentException("Registro com ID " + id + " não encontrado");
        }
        return repository.save(domain);
    }

    @Transactional
    public void delete(ID id) {
        repository.deleteById(id);
    }

    public Optional<D> getById(ID id) {
        return repository.findById(id);
    }

    public List<D> getAll() {
        return repository.findAll();
    }

}