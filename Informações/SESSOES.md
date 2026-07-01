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

### Sessão 02 — 28/06/2026 — Fase 0: Fundação — Ambiente (conclusão)

**Tempo:** ~40min

**O que fiz:**
- Subido PostgreSQL novamente via Docker Compose
- Criado `Dockerfile` multi-stage (estágio 1: build com Maven, estágio 2: runtime com JRE)
- Adicionado serviço `app` ao `docker-compose.yml` (build local + environment variables)
- Subido stack completa: `sisprot_app` + `sisprot_db` rodando em containers
- Logs confirmaram: Spring Boot 3.5.16 conectou ao PostgreSQL 16.14, HikariPool ok
- `git init` + primeiro commit com mensagem descritiva

**O que aprendi:**
- Dockerfile multi-stage: separar build (Maven+JDK) do runtime (só JRE) reduz imagem final
- Comunicação entre containers Docker: usar nome do container (`sisprot_db`), não `localhost`
- `depends_on` garante ordem de inicialização dos serviços
- `docker compose up --build` reconstrói a imagem quando há mudanças
- HikariCP é o connection pool padrão do Spring Boot
- Logs do container via `docker logs sisprot_app`

**Dúvidas que surgiram:**
- Nenhuma bloqueante

**Próxima sessão:**
- **Fase 1:** Criar entidade JPA `Processo`
- Criar pacotes: model, repository, service, controller, dto, config
- Criar migration SQL
- Implementar CRUD de Processos (primeiro endpoint REST!)
- Testar com `curl` ou navegador

### Sessão 03 — 28/06/2026 — Fase 1: MVP (CRUD + API REST) — Parte 1

**Tempo:** ~30min

**O que fiz:**
- Instalado extensões VS Code: Java Extension Pack, Spring Boot Tools, Lombok Support
- Criada estrutura de 6 pacotes: config, controller, dto, model, repository, service
- Criada entidade JPA `Processo` com @Entity, @Table, @Column, @Id, @GeneratedValue, Lombok
- Criado `schema.sql` com CREATE TABLE processos (BIGSERIAL, VARCHAR, TEXT, TIMESTAMP)
- Configurado `spring.sql.init.mode: always` no application.yaml
- Criado `ProcessoRepository` com JpaRepository + findByNumero + existsByNumero

**O que aprendi:**
- Lombok: @Data, @NoArgsConstructor, @AllArgsConstructor — eliminam boilerplate de getters/setters
- JPA: @Entity mapeia classe → tabela, @Column define constraints da coluna
- Spring Data JPA: estender JpaRepository já dá CRUD completo
- Repository: findByNumero() — Spring deduz o SQL pelo nome do método
- Injeção por construtor: melhor prática que @Autowired em campo
- schema.sql + sql.init.mode: always: Spring executa script ao iniciar

**Dúvidas que surgiram:**
- Nenhuma bloqueante

**Próxima sessão:**
- Criar `ProcessoService` com regras de negócio (criar, listar, buscar, atualizar, excluir)
- Criar DTOs (ProcessoRequestDTO, ProcessoResponseDTO)
- Criar `ProcessoController` com endpoints REST
- Reconstruir imagem Docker + testar endpoints

### Sessão 04 — 29/06/2026 — Fase 1: MVP (CRUD + API REST) — Parte 2 (conclusão)

**Tempo:** ~55min

**O que fiz:**
- Refinado `AI-INSTRUCOES.md`: modo Tutor agora usa abordagem socrática (pergunta → avalia → decide se aluno implementa ou IA gera)
- Criado `ProcessoService` com CRUD completo + regras de negócio (número duplicado, validações)
- Criados DTOs usando Java `record`: `ProcessoRequestDTO` (entrada, com Bean Validation) e `ProcessoResponseDTO` (saída, com `@JsonFormat` para datas BR)
- Criado `ProcessoController` com 5 endpoints REST: GET (listagem paginada), GET/{id}, POST, PUT/{id}, DELETE/{id}
- Criadas exceções customizadas: `ProcessoNaoEncontradoException` e `NumeroProcessoDuplicadoException` — Service 100% desacoplado de HTTP
- Criado `GlobalExceptionHandler` (`@RestControllerAdvice`) — traduz exceções de negócio em respostas HTTP (404, 409)
- Build Docker + deploy (`docker compose up --build`)
- Testados todos os endpoints: GET 200, POST 201, GET/{id} 200, POST duplicado 409, PUT 200, DELETE 204, GET/{id} após delete 404

**O que aprendi:**
- Java `record` para DTOs: acesso via `dto.numero()`, não `dto.getNumero()` — records não têm prefixo `get`
- Exceções customizadas + `@ControllerAdvice`: camada de serviço fica pura (sem imports do Spring Web)
- `@Transactional(readOnly = true)` em leituras otimiza o JPA
- `@Valid` no Controller ativa Bean Validation antes de chegar ao Service
- Encoding UTF-8 no PowerShell: `ConvertTo-Json` corrompe acentos; usar string JSON literal resolve
- Paginação com `Pageable` do Spring Data: parâmetros `?page=0&size=20&sort=titulo,asc`
- Fluxo completo da requisição: Controller → DTO (validação) → Service (regras) → Repository (persistência) → banco

**Dúvidas que surgiram:**
- Nenhuma bloqueante

**Próxima sessão:**
- Adicionar handler para erros de `@Valid` no `GlobalExceptionHandler` (retornar mensagens dos campos)
- Testar paginação com `?page=1&size=5&sort=titulo,asc`
- Iniciar **Fase 2: Relacionamentos e Validações** — criar entidades relacionadas (ex: Movimentação, Usuário)
- Git commit do progresso atual

### Sessão 05 — 30/06/2026 — Fase 2: Relacionamentos e Validações (início)

**Tempo:** ~55min

**O que fiz:**
- Adicionado handler `MethodArgumentNotValidException` no `GlobalExceptionHandler` (Opção B: mapa campo → mensagem, retorno 400)
- Testada validação com POST inválido — ✅ resposta 400 com erros por campo
- Testada paginação — ✅ page=0/1, size=3, sort=titulo,asc
- Criada entidade `Movimentacao` com `@ManyToOne` → `Processo` (bidirecional)
- Atualizado `Processo` com `@OneToMany(mappedBy = "processo", cascade = CascadeType.ALL)`
- Criado `schema.sql` para tabela `movimentacoes`
- Criados `MovimentacaoRepository`, `MovimentacaoService`, `MovimentacaoController`
- Criados DTOs: `MovimentacaoRequestDTO` (com Bean Validation) e `MovimentacaoResponseDTO`
- Criada exceção `MovimentacaoNaoEncontradaException`
- Lidado com StackOverflowError: `@JsonIgnore` + `@ToString.Exclude` + `@EqualsAndHashCode.Exclude` em relações bidirecionais
- Testados endpoints de movimentação — ✅ criar, listar por processo, buscar por id, 404, validação 400
- Adicionada dica de teste curl no `AI-INSTRUCOES.md` (`curl.exe --%`)

**O que aprendi:**
- `@OneToMany` unidirecional com `NOT NULL` na FK causa erro — JPA insere filho primeiro, depois atualiza FK
- Bidirecional (`@ManyToOne` no filho + `mappedBy`) resolve: JPA já insere com FK
- `@Data` do Lombok em relações bidirecionais exige: `@JsonIgnore` (JSON), `@ToString.Exclude` (toString), `@EqualsAndHashCode.Exclude` (hashCode) — senão StackOverflow nos 3 lugares
- `@JoinColumn` diz onde está a FK; `mappedBy` diz que o outro lado é o dono da relação
- Diferença entre `FetchType.LAZY` (carrega sob demanda) e `EAGER` (carrega sempre)
- O erro `curl.exe` no PowerShell com `--%` para evitar parsing das aspas

**Dúvidas que surgiram:**
- **`id: null` na resposta do POST de Movimentação** — investigar na próxima sessão
- **ConstraintValidator** — Fase 2 ainda tem validação customizada pendente

**Próxima sessão:**
- Investigar `id: null` no POST de Movimentação (problema de flush com IDENTITY?)
- Implementar ConstraintValidator (validação customizada — ex: setorDestino != setorOrigem, data não no futuro)
- Git commit do progresso atual
- Revisar e consolidar aprendizado da Fase 2

### Sessão 06 — 30/06/2026 — Fase 2: Relacionamentos e Validações (conclusão)

**Tempo:** ~35min

**O que fiz:**
- Investigado e resolvido `id: null` no POST de Movimentação — trocado cascade por `save` explícito no `MovimentacaoRepository`
- Removido `CascadeType.ALL` do `Processo.java` (responsabilidade explícita de salvar fica no Service)
- Implementado `@DataNaoFutura` — ConstraintValidator de campo: valida que data não é no futuro
- Implementado `@SetoresDiferentes` — ConstraintValidator de classe: valida que setorOrigem ≠ setorDestino
- Atualizado `GlobalExceptionHandler` para capturar também `globalErrors` (validações de classe)
- Testados todos os cenários: data futura, setores iguais, combinação com validações padrão
- Atualizado `DUVIDAS.md` com resposta do `id: null`

**O que aprendi:**
- `cascade` + IDENTITY pode causar `id: null` — salvar filho explicitamente (`repository.save(filho)`) é mais previsível
- ConstraintValidator tem dois tipos: `FIELD` (anotação no campo) e `TYPE` (anotação na classe)
- Validação de classe (`@Target(ElementType.TYPE)`) permite comparar campos entre si — impossível com anotações de campo
- `BindingResult.getGlobalErrors()` captura erros de validação de classe (sem campo associado)
- `ConstraintValidatorContext` pode ser usado para customizar mensagens — não precisamos, mas existe

**Dúvidas que surgiram:**
- Nenhuma nova

**Próxima sessão:**
- Fase 2 concluída ✅ — iniciar **Fundamentos de Engenharia de Software** (Semana 1: Java Core + Clean Code)
- Git commit do progresso atual

### Sessão 07 — 01/07/2026 — Planejamento: Fundamentos de Engenharia

**Tempo:** ~30min

**O que fiz:**
- Identificada necessidade de estudar fundamentos de Java, design e arquitetura antes da Fase 3 (Spring Security)
- Definido plano de 3 semanas de fundamentos usando o SISPROT como laboratório
- Criado **Modo Revisão** no `AI-INSTRUCOES.md` — protocolo para revisar código classe por classe
- Atualizado `PROJETO.md` com a fase ⚡ Fundamentos de Engenharia entre Fase 2 e 3
- Decidido: Prompt Engineering fica para projeto separado

**O que aprendi:**
- O SISPROT já contém exemplos práticos de Service Layer, Repository Pattern, DTO, ConstraintValidator, Exceptions customizadas — agora é hora de entender os "porquês"
- Modo Revisão é diferente do Tutor: não gera código, foca em análise e entendimento

**Dúvidas que surgiram:**
- Nenhuma

**Próxima sessão:**
- Iniciar **Semana 1: Java Core + Clean Code** — revisar classes do SISPROT no Modo Revisão

### Sessão 08 — 01/07/2026 — ⚡ Fundamentos: Semana 1 (Java Core + Clean Code)

**Tempo:** ~45min

**O que fiz:**
- Atualizado `AI-INSTRUCOES.md` — Modo Revisão agora segue 5 níveis top-down com aluno falando primeiro
- Revisado `Processo.java`: arquitetura em camadas, encapsulamento, `Long` vs `long`, `Set` vs `List`, Lombok, Jakarta
- Revisado `Movimentacao.java`: `@ManyToOne` vs `@OneToMany`, Interface vs Implementação, Lazy Loading, fluxo POST

**O que aprendi:**
- Java é baseado em programar para interface (`Set` = contrato, `HashSet` = mecanismo)
- `FetchType.LAZY` cria proxy que busca do banco no primeiro acesso — exige transação aberta
- DTOs existem por 4 motivos: transação, segurança, desacoplamento, formatação
- `@Data` gera código em compilação; `FetchType` controla acesso ao banco; são coisas diferentes

**Dúvidas que surgiram:**
- Nenhuma

**Próxima sessão:**
- Continuar Semana 1: `ProcessoRepository`, `MovimentacaoRepository`, `ProcessoService`, `MovimentacaoService`
