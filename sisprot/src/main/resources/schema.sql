CREATE TABLE IF NOT EXISTS processos (
    id              BIGSERIAL PRIMARY KEY,
    numero          VARCHAR(25)  NOT NULL UNIQUE,
    titulo          VARCHAR(200) NOT NULL,
    descricao       TEXT,
    interessado     VARCHAR(100) NOT NULL,
    data_criacao    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP
);