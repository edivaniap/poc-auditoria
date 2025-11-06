package com.exemplo.poc.entity.mapper;

public interface EntityMapper<D, E> {

    D toDomain(E entity);

    E toEntity(D domain);

}
