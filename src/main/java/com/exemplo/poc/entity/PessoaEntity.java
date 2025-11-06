package com.exemplo.poc.entity;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

import java.time.LocalDate;

@Audited
@Entity
@Table(schema = "comum", name = "pessoa")
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private String nomeSocial;

    private String nomeMae;

    private LocalDate dataNascimento;

}

