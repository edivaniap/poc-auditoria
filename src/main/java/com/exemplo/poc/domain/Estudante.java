package com.exemplo.poc.domain;

import lombok.Data;

@Data
public class Estudante {

    private Long id;

    private Pessoa pessoa;

    private String matricula;

    private Curso curso;

}
