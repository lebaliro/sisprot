# 📓 Registro de Sessões

> Histórico de cada sessão de estudo. Atualizar ao final de cada sessão.

---

## Formato

```markdown
### Sessão XX — [Data] — [Fase]

**Tempo:** (duração real)

**O que fiz:**
- 

**O que aprendi:**
- 

**Dúvidas que surgiram:**
- 

**Próxima sessão:**
- 
```

---

## Sessões

### Sessão 01 — 28/06/2026 — Fase 0: Fundação — Ambiente

**Tempo:** ~1h

**O que fiz:**
- Definido projeto SISPROT (Sistema de Protocolo Eletrônico) — stack Java 17 + Spring Boot 3 + PostgreSQL + Docker
- Criado `PROJETO.md` com visão geral, 12 fases, stack, padrões de projeto e regras de sessão
- Criado `SESSOES.md`, `DUVIDAS.md` como arquivos de apoio
- Gerado projeto Spring Boot 3.5.16 via Spring Initializr (Maven, Java 17, Web, JPA, PostgreSQL, Lombok, Validation, DevTools)
- Criado `docker-compose.yml` com PostgreSQL 16
- Configurado `application.yaml` com conexão ao banco
- PostgreSQL rodando via Docker (`docker compose up -d`)
- Criado `AI-INSTRUCOES.md` com protocolo de sessão para a IA

**O que aprendi:**
- Estrutura de um projeto Spring Boot: package por camada (controller, service, repository, model, dto)
- docker-compose.yml: serviços, ports, environment, volumes
- application.yaml vs application.properties — YAML mais organizado
- `spring.jpa.hibernate.ddl-auto: none` — controle manual do schema (boas práticas)
- `show-sql` + `format_sql` para ver queries no console durante aprendizado
- Spring Initializr: como gerar o esqueleto com as dependências certas

**Dúvidas que surgiram:**
- Nenhuma bloqueante

**Próxima sessão:**
- Criar estrutura de pacotes (model, repository, service, controller, dto, config)
- Criar entidade `Processo` com JPA
- Criar primeira migration SQL para tabela `processos`
- Subir aplicação Spring Boot e testar conexão com o banco
- Primeiro commit Git
