package com.exemplo.poc.entity.log;

import com.exemplo.poc.domain.Modalidade;
import jakarta.persistence.*;

@Entity
@Table(schema = "ensino_log", name = "curso")
public class CursoLog extends EntidadeLog {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Enumerated(EnumType.STRING)
    @Column(name = "nivel", length = 20, nullable = false)
    private Modalidade nivel;

}
