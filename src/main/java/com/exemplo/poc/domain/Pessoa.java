package com.exemplo.poc.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Pessoa {

    private Long id;

    private String nome;

    private String nomeSocial;

    private String nomeMae;

    private LocalDate dataNascimento;

}
