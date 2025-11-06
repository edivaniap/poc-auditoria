-- ============================================================================
-- Migration V003: Tabela Curso
-- ============================================================================

-- Criar tabela curso
CREATE TABLE ensino.curso (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    codigo VARCHAR(50) NOT NULL UNIQUE,
    carga_horaria INTEGER,
    modalidade VARCHAR(50),
    ativo BOOLEAN NOT NULL DEFAULT true,
    dh_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dh_ultima_atualizacao TIMESTAMP,
    ds_usuario_ultima_atualizacao VARCHAR(100)
);

-- Comentários
COMMENT ON TABLE ensino.curso IS 'Cadastro de cursos';
COMMENT ON COLUMN ensino.curso.codigo IS 'Código único do curso';
COMMENT ON COLUMN ensino.curso.carga_horaria IS 'Carga horária total em horas';
COMMENT ON COLUMN ensino.curso.modalidade IS 'Modalidade do curso (Presencial, EAD, etc)';

-- Índices
CREATE INDEX idx_curso_nome ON ensino.curso(nome);
CREATE INDEX idx_curso_codigo ON ensino.curso(codigo);
CREATE INDEX idx_curso_ativo ON ensino.curso(ativo);

-- Criar tabela de log
SELECT criar_tabela_log('ensino', 'curso');

-- Aplicar trigger de auditoria
SELECT aplicar_trigger_log('ensino', 'curso');