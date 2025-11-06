package com.exemplo.poc.entity;

import com.exemplo.poc.domain.Modalidade;
import jakarta.persistence.*;
import org.hibernate.envers.Audited;

@Audited
@Entity
@Table(schema = "ensino", name = "curso")
public class CursoEntity extends EntidadeAuditavel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nome", length = 150, nullable = false)
    private String nome;

    @Column(name = "codigo", length = 20, nullable = false)
    private String codigo;

    @Enumerated(EnumType.STRING)
    @Column(name = "modalidade", length = 20, nullable = false)
    private Modalidade modalidade;

}
