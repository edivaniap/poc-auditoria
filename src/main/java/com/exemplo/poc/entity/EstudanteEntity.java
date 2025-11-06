package com.exemplo.poc.entity;

import com.exemplo.poc.domain.Situacao;
import jakarta.persistence.*;
import org.hibernate.envers.Audited;

import java.time.LocalDate;

@Audited
@Entity
@Table(schema = "ensino", name = "estudante")
public class EstudanteEntity extends EntidadeAuditavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoaEntity pessoa;

    @Column(name = "matricula", length = 20, nullable = false, unique = true)
    private String matricula;

    @Column(name = "data_matricula")
    private LocalDate dataMatricula;


    @ManyToOne(optional = false)
    @JoinColumn(name = "id_curso", nullable = false)
    private CursoEntity curso;

    @Enumerated(EnumType.STRING)
    @Column(name = "situacao")
    private Situacao situacao;

}