CREATE TABLE pessoas (
    id BIGSERIAL PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);

CREATE TABLE habitos (
    id BIGSERIAL PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    descricao VARCHAR(255),
    frequencia VARCHAR(50) NOT NULL,
    pessoa_id BIGINT NOT NULL,
    CONSTRAINT fk_habitos_pessoas FOREIGN KEY (pessoa_id) REFERENCES pessoas(id)
);