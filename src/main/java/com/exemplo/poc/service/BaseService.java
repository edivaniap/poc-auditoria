package com.exemplo.poc.service;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

public interface BaseService<D, ID> {

    D save(D domain);

    D update(ID id, D domain);

    void delete(ID id);

    Optional<D> getById(ID id);

    List<D> getAll();

}
