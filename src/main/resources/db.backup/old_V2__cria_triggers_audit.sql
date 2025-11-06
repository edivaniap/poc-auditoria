-- =========================
-- Funções e Triggers: PESSOA
-- =========================
CREATE OR REPLACE FUNCTION auditoria.log_pessoa_changes()
RETURNS TRIGGER AS $$
BEGIN
    IF TG_OP = 'INSERT' THEN
        INSERT INTO auditoria.pessoa_aud_trigger(operation, id, nome, nome_social, nome_mae, data_nascimento)
        VALUES ('I', NEW.id, NEW.nome, NEW.nomeSocial, NEW.nomeMae, NEW.dataNascimento);
        RETURN NEW;
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO auditoria.pessoa_aud_trigger(operation, id, nome, nome_social, nome_mae, data_nascimento)
        VALUES ('U', NEW.id, NEW.nome, NEW.nomeSocial, NEW.nomeMae, NEW.dataNascimento);
        RETURN NEW;
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO auditoria.pessoa_aud_trigger(operation, id, nome, nome_social, nome_mae, data_nascimento)
        VALUES ('D', OLD.id, OLD.nome, OLD.nomeSocial, OLD.nomeMae, OLD.dataNascimento);
        RETURN OLD;
    END IF;
END;
$$ LANGUAGE plpgsql;

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM pg_trigger WHERE tgname = 'trg_pessoa_audit'
    ) THEN
        CREATE TRIGGER trg_pessoa_audit
        AFTER INSERT OR UPDATE OR DELETE ON comum.pessoa
        FOR EACH ROW EXECUTE FUNCTION auditoria.log_pessoa_changes();
    END IF;
END $$;


-- =========================
-- Funções e Triggers: ESTUDANTE
-- =========================
CREATE OR REPLACE FUNCTION auditoria.log_estudante_changes()
RETURNS TRIGGER AS $$
BEGIN
    IF TG_OP = 'INSERT' THEN
        INSERT INTO auditoria.estudante_aud_trigger(operation, id, pessoa_id, matricula, curso_id)
        VALUES ('I', NEW.id, NEW.pessoa_id, NEW.matricula, NEW.curso_id);
        RETURN NEW;
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO auditoria.estudante_aud_trigger(operation, id, pessoa_id, matricula, curso_id)
        VALUES ('U', NEW.id, NEW.pessoa_id, NEW.matricula, NEW.curso_id);
        RETURN NEW;
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO auditoria.estudante_aud_trigger(operation, id, pessoa_id, matricula, curso_id)
        VALUES ('D', OLD.id, OLD.pessoa_id, OLD.matricula, OLD.curso_id);
        RETURN OLD;
    END IF;
END;
$$ LANGUAGE plpgsql;

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM pg_trigger WHERE tgname = 'trg_estudante_audit'
    ) THEN
        CREATE TRIGGER trg_estudante_audit
        AFTER INSERT OR UPDATE OR DELETE ON ensino.estudante
        FOR EACH ROW EXECUTE FUNCTION auditoria.log_estudante_changes();
    END IF;
END $$;


-- =========================
-- Funções e Triggers: CURSO
-- =========================
CREATE OR REPLACE FUNCTION auditoria.log_curso_changes()
RETURNS TRIGGER AS $$
BEGIN
    IF TG_OP = 'INSERT' THEN
        INSERT INTO auditoria.curso_aud_trigger(operation, id, nome, nivel)
        VALUES ('I', NEW.id, NEW.nome, NEW.nivel);
        RETURN NEW;
    ELSIF TG_OP = 'UPDATE' THEN
        INSERT INTO auditoria.curso_aud_trigger(operation, id, nome, nivel)
        VALUES ('U', NEW.id, NEW.nome, NEW.nivel);
        RETURN NEW;
    ELSIF TG_OP = 'DELETE' THEN
        INSERT INTO auditoria.curso_aud_trigger(operation, id, nome, nivel)
        VALUES ('D', OLD.id, OLD.nome, OLD.nivel);
        RETURN OLD;
    END IF;
END;
$$ LANGUAGE plpgsql;

DO $$
BEGIN
    IF NOT EXISTS (
        SELECT 1 FROM pg_trigger WHERE tgname = 'trg_curso_audit'
    ) THEN
        CREATE TRIGGER trg_curso_audit
        AFTER INSERT OR UPDATE OR DELETE ON ensino.curso
        FOR EACH ROW EXECUTE FUNCTION auditoria.log_curso_changes();
    END IF;
END $$;
