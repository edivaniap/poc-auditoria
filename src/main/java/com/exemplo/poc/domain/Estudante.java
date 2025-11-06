package com.exemplo.poc.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Estudante {

    private Long id;

    private Pessoa pessoa;

    private String matricula;

    private LocalDate dataMatricula;

    private Curso curso;

    private Situacao situacao;

}
