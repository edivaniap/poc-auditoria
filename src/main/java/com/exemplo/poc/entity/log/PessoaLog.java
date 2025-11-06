package com.exemplo.poc.entity.log;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(schema = "comum_log", name = "pessoa")
public class PessoaLog extends EntidadeLog {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Column(name = "nome_social", length = 150)
    private String nomeSocial;

    @Column(name = "nome_mae", length = 150)
    private String nomeMae;

    @Column(name = "data_nascimento")
    private LocalDate dataNascimento;

}
