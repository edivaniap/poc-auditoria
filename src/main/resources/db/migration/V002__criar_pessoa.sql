-- ============================================================================
-- Migration V002: Tabela Pessoa
-- ============================================================================

-- Criar tabela pessoa
CREATE TABLE comum.pessoa (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    nome_social VARCHAR(200),
    nome_mae VARCHAR(200),
    data_nascimento DATE,
    dh_criacao TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    dh_ultima_atualizacao TIMESTAMP,
    ds_usuario_ultima_atualizacao VARCHAR(100)
);

-- Comentários
COMMENT ON TABLE comum.pessoa IS 'Cadastro de pessoas';
COMMENT ON COLUMN comum.pessoa.nome IS 'Nome completo da pessoa';
COMMENT ON COLUMN comum.pessoa.nome_social IS 'Nome social (opcional)';
COMMENT ON COLUMN comum.pessoa.nome_mae IS 'Nome da mãe';
COMMENT ON COLUMN comum.pessoa.data_nascimento IS 'Data de nascimento';

-- Índices
CREATE INDEX idx_pessoa_nome ON comum.pessoa(nome);
CREATE INDEX idx_pessoa_data_nascimento ON comum.pessoa(data_nascimento);

-- Criar tabela de log
SELECT criar_tabela_log('comum', 'pessoa');

-- Aplicar trigger de auditoria
SELECT aplicar_trigger_log('comum', 'pessoa');