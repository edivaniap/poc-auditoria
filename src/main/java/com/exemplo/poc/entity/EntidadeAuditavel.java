package com.exemplo.poc.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.time.LocalDateTime;

@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class EntidadeAuditavel {

    @Column(name = "dh_criacao", nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime dhCriacao;

    @Column(name = "dh_ultima_atualizacao")
    @LastModifiedDate
    private LocalDateTime dhUltimaAtualizacao;

    @Column(name = "ds_usuario_ultima_atualizacao", length = 100)
    private String dsUsuarioUltimaAtualizacao;

    @PrePersist
    @PreUpdate
    private void setUsuario() {
        this.dsUsuarioUltimaAtualizacao = obterUsuarioAtual();
    }

    private String obterUsuarioAtual() {
        try {
            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
            return auth != null ? auth.getName() : "SISTEMA";
        } catch (Exception e) {
            return "SISTEMA";
        }
    }

}