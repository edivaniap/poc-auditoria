package com.exemplo.poc.entity.log;

import com.exemplo.poc.entity.CursoEntity;
import com.exemplo.poc.entity.PessoaEntity;
import jakarta.persistence.*;

@Entity
@Table(schema = "ensino_log", name = "estudante")
public class EstudanteLog extends EntidadeLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_pessoa", nullable = false)
    private PessoaEntity pessoa;

    @Column(name = "matricula", length = 20, nullable = false, unique = true)
    private String matricula;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_curso", nullable = false)
    private CursoEntity curso;

}
