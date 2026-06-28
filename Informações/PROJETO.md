# � SISPROT — Sistema de Protocolo Eletrônico

> **Objetivo:** Projeto pessoal para aprendizado prático de desenvolvimento back-end, com foco em me preparar para o cargo de **Analista de TI / Arquitetura e Desenvolvimento de Sistemas – Back-End da UFCA**.
>
> **Mentalidade:** Evitar "vibe coding". Fazer manualmente, usar a IA como tutora para tirar dúvidas e revisar decisões.
>
> **Plano completo:** Ver `plano-estudo.md` na memória do repositório.

---

## 🎯 Visão Geral

Sistema de tramitação de documentos e processos administrativos — presente em toda instituição federal brasileira. Permite criar, movimentar, anexar documentos e acompanhar o ciclo de vida de processos administrativos, com controle de acesso por perfis de usuário.

---

## 🏛️ Stack Tecnológica

| Categoria | Tecnologia | Justificativa |
|---|---|---|
| **Linguagem** | Java 17+ | Padrão em IFES |
| **Framework** | Spring Boot 3 | Ecossistema dominante no serviço público |
| **Banco de Dados** | PostgreSQL (via Docker) | SGBD oficial da maioria das universidades federais |
| **Containerização** | Docker + Docker Compose | Ambiente isolado e reproduzível |
| **Autenticação** | Spring Security + JWT | Segurança stateless padrão |
| **Documentação** | SpringDoc OpenAPI | Documentação interativa de APIs |
| **Testes** | JUnit 5 + Mockito + Testcontainers | Qualidade de software |
| **Cache** | Redis | Performance |
| **Mensageria** | RabbitMQ | Comunicação assíncrona |
| **Versionamento** | Git + GitHub | Portfólio e colaboração |
| **Build** | Maven | Gerenciamento de dependências |

---

## 🗺️ Fases do Projeto (12 Fases)

> Cada fase introduz novos conceitos de forma progressiva.
> O plano detalhado com tarefas, conceitos e checklists está em `plano-estudo.md`.

| Fase | Tema | Conceitos-Chave |
|---|---|---|
| **0** | Fundação — Ambiente | Docker, Spring Boot anatomy, Maven |
| **1** | CRUD de Processos | JPA, Repository, Service, Controller, DTO, paginação |
| **2** | Relacionamentos e Validações | @OneToMany, Bean Validation, ConstraintValidator |
| **3** | Autenticação e Autorização | Spring Security, JWT, BCrypt, RBAC |
| **4** | Upload de Documentos | Multipart upload, File Storage |
| **5** | Workflow — Máquina de Estados | State Machine, transições, regras de negócio |
| **6** | Busca Avançada e Filtros | JPQL, Criteria API, Specification Pattern |
| **7** | Cache e Performance | Redis, @Cacheable, índices PostgreSQL |
| **8** | Testes Automatizados | JUnit, Mockito, Testcontainers, JaCoCo |
| **9** | Documentação da API | OpenAPI, Swagger, SpringDoc |
| **10** | Mensageria com RabbitMQ | Spring AMQP, DLQ, eventos assíncronos |
| **11** | Deploy e CI/CD | Dockerfile multi-stage, GitHub Actions |
| **12** | Bônus — Microsserviços | Service Discovery, API Gateway |

---

## 🧑‍🏫 Metodologia de Estudo — Dois Modos

| Modo | Como funciona | Quando usar |
|---|---|---|
| **Tutor** | Você implementa, eu explico, reviso e corrijo | Fases 0-4 (construir base) |
| **Comando** | Você dá instruções específicas, eu gero código | Fases 5+ (acelerar) |
| **Híbrido** | Mistura flexível dos dois anteriores | Qualquer momento |

---

## ⏱️ Regras de Sessão

1. **Duração:** 1 hora por sessão, com alarme configurado
2. **Checkpoint:** A cada 30 min, ver progresso
3. **Resumo:** Últimos 5 min, anotar o que foi feito
4. **Git commit:** Sempre ao final da sessão
5. **Qualidade > Quantidade:** 1 conceito bem entendido > 3 superficiais
6. **Arquivos de apoio:** `DUVIDAS.md` + `SESSOES.md`

---

### Extensões necessárias no VS Code

| Extensão | ID | Função |
|---|---|---|
| **Extension Pack for Java** | `vscjava.vscode-java-pack` | Pacote completo: linguagem, debug, testes, Maven/Gradle |
| **Spring Boot Extension Pack** | `vmware.vscode-spring-boot` | Suporte a Spring Boot, navegação, propriedades |
| **Lombok Annotations Support** | `vscjava.vscode-lombok` | Suporte ao Lombok (reduz boilerplate) |
| **PostgreSQL** (opcional) | `ckolkman.vscode-postgres` | Conectar e consultar o banco direto do VS Code |

### Fase 1 — MVP (CRUD + API REST)

| Conceito | O que estudar |
|---|---|
| **RESTful API Design** | Verbos HTTP, recursos nomeados no plural, status codes (200, 201, 400, 404, 500) |
| **Padrão DTO** | Por que não expor a entidade JPA diretamente? Separação de camadas |
| **Padrão Repository + Service** | Persistência vs regra de negócio — responsabilidades distintas |
| **Bean Validation** | `@Valid`, `@NotNull`, `@NotBlank`, `@Size` — evitar lixo no banco |
| **Injeção de Dependência (DI/IoC)** | `@Autowired`, `@Service`, `@Repository` — o container Spring gerenciando objetos |
| **Padrão MVC** | Model-View-Controller — fluxo da requisição HTTP até a resposta |
| **Banco de Dados Relacional** | Normalização, PK/FK, índices, tipos SQL |

### Fase 2 — Upload e Processamento de Arquivos

| Conceito | O que estudar |
|---|---|
| **Upload de arquivos em APIs REST** | `multipart/form-data`, limites de tamanho, validação de tipo MIME |
| **Metadados EXIF** | Estrutura, tags GPS, conversão GMS → Graus Decimais, privacidade |
| **Armazenamento de arquivos** | Disco local vs nuvem (S3), servir arquivos estáticos |
| **Processamento assíncrono (introdução)** | `@Async` do Spring — por que processar uploads em background? |
| **Tratamento de exceções global** | `@ControllerAdvice` + `@ExceptionHandler` |
| **Logging** | SLF4J + Logback, níveis de log (INFO, DEBUG, ERROR) |

### Fase 3 — App Android e Integração

| Conceito | O que estudar |
|---|---|
| **Comunicação HTTP no Android** | Retrofit/OkHttp, serialização JSON, erros de rede |
| **Android Intents** | `IntentFilter`, `ACTION_SEND`, fluxo de compartilhamento |
| **Segurança de API (básico)** | API keys como primeiro passo de proteção |
| **CORS** | Por que o navegador bloqueia requisições entre origens diferentes |

### Fase 4 — Funcionalidades Sociais

| Conceito | O que estudar |
|---|---|
| **Relacionamentos JPA** | `@OneToMany`, `@ManyToOne`, `@ManyToMany`, eager/lazy, N+1 problem |
| **Autenticação e Autorização** | Spring Security, JWT (Access + Refresh Token), BCrypt |
| **Modelagem de dados** | Quando criar entidade nova vs adicionar campos |
| **Consultas avançadas** | JPQL, `@Query`, projections, paginação com `Pageable` |

### Fase 5 — Testes e Documentação

| Conceito | O que estudar |
|---|---|
| **Pirâmide de Testes** | Unitários (base), Integração (meio), E2E (topo) — proporção e custo |
| **JUnit 5 + Mockito** | `@Mock`, `@InjectMocks`, `when().thenReturn()`, `verify()` |
| **Testes de Integração Spring** | `@SpringBootTest`, `@DataJpaTest`, `@WebMvcTest`, TestContainers |
| **TDD** | Red → Green → Refactor — escrever teste antes do código |
| **Documentação de API** | OpenAPI 3.0, SpringDoc, Swagger UI |
| **Postman / Insomnia** | Collections, environments, testes automatizados de API |

### Fase 6 — Deploy e Produção

| Conceito | O que estudar |
|---|---|
| **12-Factor App** | Princípios para aplicações cloud-native |
| **CI/CD (básico)** | GitHub Actions — build e deploy automático |
| **Docker (avançado)** | Dockerfile para app, docker-compose para app + banco |
| **Variáveis de ambiente** | Separar código de configuração, `.env`, secrets |
| **Monitoramento** | Health checks, logs em produção, Sentry |
| **HTTPS e Certificados** | Por que HTTPS é obrigatório, Let's Encrypt |

---

## 🧱 Padrões de Projeto (Design Patterns) Relevantes

> Catálogo dos padrões GoF que aparecerão naturalmente durante o desenvolvimento.

| Padrão | Categoria | Onde vai aparecer no projeto |
|---|---|---|
| **Singleton** | Criacional | Beans Spring (por padrão são singleton no container) |
| **Builder** | Criacional | `Foto.builder()`, construção de objetos complexos (Lombok `@Builder`) |
| **Factory Method** | Criacional | Criação de entidades a partir de DTOs, estratégias de extração de metadados |
| **Strategy** | Comportamental | Diferentes formas de processar fotos (EXIF JPEG vs PNG), armazenamento (disco vs nuvem) |
| **Observer** | Comportamental | Eventos do Spring (`@EventListener`) — "ao salvar foto, notificar serviço de mapa" |
| **Template Method** | Comportamental | `JdbcTemplate`, `RestTemplate` — o Spring usa intensamente |
| **Proxy** | Estrutural | `@Transactional` — cria proxy para gerenciar transações |
| **Decorator** | Estrutural | Filtros e interceptors do Spring (`HandlerInterceptor`, `Filter`) |
| **Repository** | Arquitetural | Spring Data JPA — abstrai acesso a dados |
| **DTO** | Arquitetural | Separar modelo de banco do modelo exposto na API |

---

## 🧩 Tópicos Avançados (para depois do MVP)

> Conceitos além do escopo inicial, mas muito valorizados em cargos de arquitetura back-end.

- [ ] **Filas e Mensageria** — RabbitMQ / Kafka para processamento assíncrono de uploads
- [ ] **Cache** — Redis para consultas frequentes (ex: lista de fotos)
- [ ] **API Gateway** — Spring Cloud Gateway para roteamento
- [ ] **Microsserviços** — Quando e por que quebrar o monolito
- [ ] **Banco geoespacial** — PostGIS para consultas por proximidade ("fotos perto de mim")
- [ ] **Resiliência** — Circuit Breaker (Resilience4j), retry, timeout
- [ ] **Observabilidade** — Prometheus + Grafana, tracing distribuído
- [ ] **Domain-Driven Design (DDD)** — Entidades, Value Objects, Agregados, Bounded Contexts

---

## �📋 Progresso Atual

| Fase | Status | Início | Conclusão |
|---|---|---|---|
| Fase 0: Ambiente | � Em andamento | 28/06/2026 | — |
| Fase 1: MVP | 🔴 Não iniciada | — | — |
| Fase 2: Processamento | 🔴 Não iniciada | — | — |
| Fase 3: Mobile | 🔴 Não iniciada | — | — |
| Fase 4: Social | 🔴 Não iniciada | — | — |
| Fase 5: Qualidade | 🔴 Não iniciada | — | — |
| Fase 6: Publicação | 🔴 Não iniciada | — | — |

> **Status:** 🔴 Não iniciada | 🟡 Em andamento | 🟢 Concluída

---

## 🧠 Decisões de Arquitetura (ADR)

> Registrar aqui as decisões técnicas importantes e por que foram tomadas.

| # | Data | Decisão | Motivo | Alternativas consideradas |
|---|---|---|---|---|
| 1 | 2026-06-27 | PostgreSQL rodando em container Docker | Ambiente isolado, evita instalar dependências direto no Windows, reproduzível com um comando, aprendizado de Docker já na Fase 0 | Instalação nativa do PostgreSQL no Windows |
| 2 | 2026-06-27 | VS Code como IDE principal (com extensões Java + Spring) | Já está usando, mais leve que IntelliJ IDEA, aprendizado mais explícito | IntelliJ IDEA, Spring Tool Suite |

---

## 📓 Log de Sessões

> Atualizar a cada sessão de estudo/desenvolvimento.

### Template
```
### [DATA] — Fase X: [Título]
**Feito:** 
- 

**Dúvidas/Blockers:** 
- 

**Aprendizados:** 
- 

**Próxima sessão:** 
- 
```

---

## 🔗 Referências

- [Documentação oficial Spring Boot](https://docs.spring.io/spring-boot/documentation.html)
- [Documentação PostgreSQL](https://www.postgresql.org/docs/)
- [Documentação Docker](https://docs.docker.com/)
- [Documentação Docker Compose](https://docs.docker.com/compose/)
- [Leaflet.js](https://leafletjs.com/reference.html)
- [metadata-extractor (Java)](https://github.com/drewnoakes/metadata-extractor)
- [Guia Android IntentFilter](https://developer.android.com/training/sharing/receive)
- [SpringDoc OpenAPI](https://springdoc.org/)
- [Spring Initializr](https://start.spring.io/)
- [Extension Pack for Java (VS Code)](https://marketplace.visualstudio.com/items?itemName=vscjava.vscode-java-pack)
- [Spring Boot Extension Pack (VS Code)](https://marketplace.visualstudio.com/items?itemName=vmware.vscode-spring-boot)

---

## 💡 Lembretes

- Commitar com frequência e escrever mensagens de commit claras
- Manter o `README.md` do GitHub atualizado como portfólio
- Sempre se perguntar: "Como isso escala? Como isso seria em produção?"
- A cada fase concluída, revisar e refatorar antes de avançar
