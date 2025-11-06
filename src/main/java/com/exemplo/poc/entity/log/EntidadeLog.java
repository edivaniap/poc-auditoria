package com.exemplo.poc.entity.log;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
public abstract class EntidadeLog {

    @Column(name = "tp_atualizacao", nullable = false, length = 1)
    private String tpAtualizacao; // 'I' ou 'U'

    @Column(name = "dh_log", nullable = false)
    private LocalDateTime dhLog;

    // Campos de auditoria da tabela original
    @Column(name = "dh_criacao")
    private LocalDateTime dhCriacao;

    @Column(name = "dh_ultima_atualizacao")
    private LocalDateTime dhUltimaAtualizacao;

    @Column(name = "ds_usuario_ultima_atualizacao")
    private String dsUsuarioUltimaAtualizacao;

}