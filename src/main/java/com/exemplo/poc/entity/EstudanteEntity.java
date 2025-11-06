package com.exemplo.poc.entity;

import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(schema = "ensino", name = "estudante")
public class EstudanteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    private PessoaEntity pessoa;

    private String matricula;

    @ManyToOne(optional = false)
    private CursoEntity curso;

}