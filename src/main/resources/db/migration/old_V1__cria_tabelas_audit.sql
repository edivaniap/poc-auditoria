-- =========================
-- Tabelas de auditoria
-- =========================
CREATE SCHEMA IF NOT EXISTS auditoria;

-- Auditoria da tabela pessoa
CREATE TABLE IF NOT EXISTS auditoria.pessoa_aud_trigger (
    audit_id BIGSERIAL PRIMARY KEY,
    operation CHAR(1) NOT NULL,
    changed_at TIMESTAMP DEFAULT now(),
    changed_by TEXT DEFAULT current_user,
    id BIGINT,
    nome TEXT,
    nome_social TEXT,
    nome_mae TEXT,
    data_nascimento DATE
);

-- Auditoria da tabela estudante
CREATE TABLE IF NOT EXISTS auditoria.estudante_aud_trigger (
    audit_id BIGSERIAL PRIMARY KEY,
    operation CHAR(1) NOT NULL,
    changed_at TIMESTAMP DEFAULT now(),
    changed_by TEXT DEFAULT current_user,
    id BIGINT,
    pessoa_id BIGINT,
    matricula TEXT,
    curso_id BIGINT
);

-- Auditoria da tabela curso
CREATE TABLE IF NOT EXISTS auditoria.curso_aud_trigger (
    audit_id BIGSERIAL PRIMARY KEY,
    operation CHAR(1) NOT NULL, -- I = insert, U = update, D = delete
    changed_at TIMESTAMP DEFAULT now(),
    changed_by TEXT DEFAULT current_user,
    id BIGINT,
    nome TEXT,
    nivel TEXT
);

