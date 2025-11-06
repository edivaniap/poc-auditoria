-- ============================================================================
-- Migration V001: Setup inicial de auditoria
-- ============================================================================

-- Criar schemas
CREATE SCHEMA IF NOT EXISTS comum;
CREATE SCHEMA IF NOT EXISTS comum_log;
CREATE SCHEMA IF NOT EXISTS ensino;
CREATE SCHEMA IF NOT EXISTS ensino_log;

-- ============================================================================
-- Funções de Auditoria (Reutilizáveis)
-- ============================================================================

-- Função para criar tabela de log espelho
CREATE OR REPLACE FUNCTION criar_tabela_log(
    p_schema_origem VARCHAR,
    p_tabela_origem VARCHAR
) RETURNS VOID AS $$
DECLARE
    v_schema_log VARCHAR := p_schema_origem || '_log';
    v_sql TEXT;
BEGIN
    -- Gera DDL da tabela espelho
    v_sql := format('
        CREATE TABLE IF NOT EXISTS %I.%I (
            LIKE %I.%I INCLUDING DEFAULTS INCLUDING CONSTRAINTS,
            tp_atualizacao CHAR(1) NOT NULL CHECK (tp_atualizacao IN (''I'', ''U'')),
            dh_log TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
        )',
        v_schema_log, p_tabela_origem,
        p_schema_origem, p_tabela_origem
    );

    EXECUTE v_sql;

    -- Cria índices úteis
    EXECUTE format('
        CREATE INDEX IF NOT EXISTS idx_%I_dh_log
        ON %I.%I(dh_log DESC)',
        p_tabela_origem, v_schema_log, p_tabela_origem
    );

    EXECUTE format('
        CREATE INDEX IF NOT EXISTS idx_%I_tp_atualizacao
        ON %I.%I(tp_atualizacao)',
        p_tabela_origem, v_schema_log, p_tabela_origem
    );

    -- Se a tabela tem ID, cria índice composto
    IF EXISTS (
        SELECT 1 FROM information_schema.columns
        WHERE table_schema = p_schema_origem
        AND table_name = p_tabela_origem
        AND column_name = 'id'
    ) THEN
        EXECUTE format('
            CREATE INDEX IF NOT EXISTS idx_%I_id_dh_log
            ON %I.%I(id, dh_log DESC)',
            p_tabela_origem, v_schema_log, p_tabela_origem
        );
    END IF;

    RAISE NOTICE 'Tabela de log criada: %.%', v_schema_log, p_tabela_origem;
END;
$$ LANGUAGE plpgsql;

-- Função de trigger que replica dados para tabela _log
CREATE OR REPLACE FUNCTION fn_auditoria_log()
RETURNS TRIGGER AS $$
DECLARE
    v_schema_log VARCHAR;
    v_tp_atualizacao CHAR(1);
    v_sql TEXT;
    v_dados RECORD;
BEGIN
    -- Define schema de log
    v_schema_log := TG_TABLE_SCHEMA || '_log';

    -- Define tipo de atualização
    IF (TG_OP = 'INSERT') THEN
        v_tp_atualizacao := 'I';
        v_dados := NEW;
    ELSIF (TG_OP = 'UPDATE') THEN
        v_tp_atualizacao := 'U';
        v_dados := NEW;
    ELSE
        -- Não audita DELETE neste padrão
        RETURN OLD;
    END IF;

    -- Monta SQL dinâmico para inserir no log
    v_sql := format('
        INSERT INTO %I.%I
        SELECT $1.*, $2, CURRENT_TIMESTAMP',
        v_schema_log, TG_TABLE_NAME
    );

    EXECUTE v_sql USING v_dados, v_tp_atualizacao;

    RETURN v_dados;
END;
$$ LANGUAGE plpgsql;

-- Função para aplicar trigger em uma tabela
CREATE OR REPLACE FUNCTION aplicar_trigger_log(
    p_schema VARCHAR,
    p_tabela VARCHAR
) RETURNS VOID AS $$
DECLARE
    v_trigger_name VARCHAR;
BEGIN
    v_trigger_name := 'trg_log_' || p_tabela;

    EXECUTE format('
        DROP TRIGGER IF EXISTS %I ON %I.%I',
        v_trigger_name, p_schema, p_tabela
    );

    EXECUTE format('
        CREATE TRIGGER %I
        AFTER INSERT OR UPDATE ON %I.%I
        FOR EACH ROW
        EXECUTE FUNCTION fn_auditoria_log()',
        v_trigger_name, p_schema, p_tabela
    );

    RAISE NOTICE 'Trigger aplicado: % em %.%', v_trigger_name, p_schema, p_tabela;
END;
$$ LANGUAGE plpgsql;