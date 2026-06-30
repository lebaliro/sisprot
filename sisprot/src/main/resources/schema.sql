CREATE TABLE IF NOT EXISTS processos (
    id              BIGSERIAL PRIMARY KEY,
    numero          VARCHAR(25)  NOT NULL UNIQUE,
    titulo          VARCHAR(200) NOT NULL,
    descricao       TEXT,
    interessado     VARCHAR(100) NOT NULL,
    data_criacao    TIMESTAMP    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    data_atualizacao TIMESTAMP
);

CREATE TABLE IF NOT EXISTS movimentacoes (
    id                   BIGSERIAL PRIMARY KEY,
    processo_id          BIGINT        NOT NULL REFERENCES processos(id),
    data_movimentacao    TIMESTAMP     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    setor_origem         VARCHAR(100)  NOT NULL,
    setor_destino        VARCHAR(100)  NOT NULL,
    despacho             VARCHAR(500)  NOT NULL,
    usuario_responsavel  VARCHAR(100)  NOT NULL
);