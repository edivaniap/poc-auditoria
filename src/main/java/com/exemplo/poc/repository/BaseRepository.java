package com.exemplo.poc.repository;

import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.Optional;

@NoRepositoryBean
public interface BaseRepository<D, ID> {

    D save(D domain);

    Optional<D> findById(ID id);

    List<D> findAll();

    void deleteById(ID id);

    boolean existsById(ID id);

}