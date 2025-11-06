package com.exemplo.poc.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
