package com.exemplo.poc.repository;

import com.exemplo.poc.entity.mapper.EntityMapper;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class BaseRepositoryImpl<D, E, ID> implements BaseRepository<D, ID> {

    protected final JpaRepository<E, ID> jpaRepository;
    protected final EntityMapper<D, E> mapper;

    protected BaseRepositoryImpl(JpaRepository<E, ID> jpaRepository, EntityMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public D save(D domain) {
        E entity = mapper.toEntity(domain);
        E saved = jpaRepository.save(entity);
        return mapper.toDomain(saved);
    }

    @Override
    public Optional<D> findById(ID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<D> findAll() {
        return jpaRepository.findAll().stream().map(mapper::toDomain).collect(Collectors.toList());
    }

    @Override
    public void deleteById(ID id) {
        jpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(ID id) {
        return jpaRepository.existsById(id);
    }

}