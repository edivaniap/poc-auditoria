package com.exemplo.poc.domain;

import lombok.Data;

@Data
public class Curso {

    private Long id;

    private String nome;

    private String codigo;

    private Modalidade modalidade;

}