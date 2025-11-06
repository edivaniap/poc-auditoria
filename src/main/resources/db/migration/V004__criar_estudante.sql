-- ============================================================================
-- Migration V004: Tabela Estudante
-- ============================================================================

-- Criar tabela estudante
CREATE TABLE ensino.estudante (
    id BIGSERIAL PRIMARY KEY,
    id_pessoa BIGINT NOT NULL,
    matricula VARCHAR(50) NOT NULL UNIQUE,
    id_curso BIGINT NOT NULL,
    data_matricula DATE NOT NULL DEFAULT CURRENT_DATE,
    situacao VARCHAR(50) NOT NULL DEFAULT 'ATIVO',
    dh_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dh_ultima_atualizacao TIMESTAMP,
    ds_usuario_ultima_atualizacao VARCHAR(100),

    -- Foreign Keys
    CONSTRAINT fk_estudante_pessoa
        FOREIGN KEY (id_pessoa)
        REFERENCES comum.pessoa(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    CONSTRAINT fk_estudante_curso
        FOREIGN KEY (id_curso)
        REFERENCES ensino.curso(id)
        ON DELETE RESTRICT
        ON UPDATE CASCADE,

    -- Constraints
    CONSTRAINT chk_estudante_situacao
        CHECK (situacao IN ('ATIVO', 'TRANCADO', 'CONCLUIDO', 'CANCELADO'))
);

-- Comentários
COMMENT ON TABLE ensino.estudante IS 'Cadastro de estudantes';
COMMENT ON COLUMN ensino.estudante.matricula IS 'Matrícula única do estudante';
COMMENT ON COLUMN ensino.estudante.situacao IS 'Situação atual do estudante';

-- Índices
CREATE INDEX idx_estudante_id_pessoa ON ensino.estudante(id_pessoa);
CREATE INDEX idx_estudante_id_curso ON ensino.estudante(id_curso);
CREATE INDEX idx_estudante_matricula ON ensino.estudante(matricula);
CREATE INDEX idx_estudante_situacao ON ensino.estudante(situacao);
CREATE INDEX idx_estudante_data_matricula ON ensino.estudante(data_matricula);

-- Criar tabela de log
SELECT criar_tabela_log('ensino', 'estudante');

-- Aplicar trigger de auditoria
SELECT aplicar_trigger_log('ensino', 'estudante');