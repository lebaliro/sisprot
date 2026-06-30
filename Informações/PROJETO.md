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
| **13** | Bônus — Interface Web | Thymeleaf, Bootstrap, templates server-side (preparação para realidade do cargo) |

---

## ⚠️ Realidade do Cargo — Back-End + Interface

> **Contexto:** Pesquisa informal confirmou que a UFCA **não tem cargo específico de frontend**.
> Na prática, o analista back-end frequentemente precisa entregar interfaces funcionais.

### O que isso significa para o projeto

| Não é esperado | É esperado |
|---|---|
| Design sofisticado, Figma, UX research | Telas funcionais (tabela + formulário + CRUD) |
| React/Vue/Angular avançado | Thymeleaf com Bootstrap (mesma stack Java) |
| Acessibilidade, animações, responsividade | Interface administrativa interna simples |

### Estratégia

1. **Fases 1-11:** Foco total em back-end (core do cargo)
2. **Fase 13 (opcional):** Thymeleaf + Bootstrap — adicionar camada web à mesma aplicação Spring Boot
3. Thymeleaf é escolha natural: roda no servidor, mesma stack, curva baixa para quem já sabe Java

> 🎯 O domínio do back-end é o diferencial. Telas funcionais se aprendem em dias.
> Mas estar preparado para entregar ambas as pontas é a realidade do serviço público federal.

---

## 🧑‍🏫 Metodologia de Estudo — Simulação de Trabalho Real

> O objetivo é simular o dia a dia de um profissional de TI em 2026: tomar decisões, avaliar código gerado por IA, questionar escolhas e justificar arquitetura.

| Modo | Como funciona | Quando usar |
|---|---|---|
| **Tutor** | IA traz contexto + opções → você decide → IA gera código → você revisa e questiona | Fases 0-4 (construir base) |
| **Comando** | Você dá instruções específicas, IA executa sem questionar | Fases 5+ (acelerar) |
| **Híbrido** | Mistura flexível dos dois anteriores | Qualquer momento |

> 📋 O protocolo detalhado está no `AI-INSTRUCOES.md` (fluxo de 7 passos).

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

---

## 🧱 Padrões de Projeto (Design Patterns) Relevantes

> Catálogo dos padrões GoF que aparecerão naturalmente durante o desenvolvimento.

| Padrão | Categoria | Onde vai aparecer no projeto |
|---|---|---|
| **Singleton** | Criacional | Beans Spring (por padrão são singleton no container) |
| **Builder** | Criacional | Construção de objetos complexos via Lombok `@Builder` |
| **Factory Method** | Criacional | Criação de entidades a partir de DTOs |
| **Strategy** | Comportamental | Workflow de tramitação — diferentes estratégias por tipo de processo |
| **Observer** | Comportamental | Eventos do Spring (`@EventListener`) — "ao movimentar processo, notificar interessado" |
| **Template Method** | Comportamental | `JdbcTemplate`, `RestTemplate` — o Spring usa intensamente |
| **Proxy** | Estrutural | `@Transactional` — cria proxy para gerenciar transações |
| **Decorator** | Estrutural | Filtros e interceptors do Spring (`HandlerInterceptor`, `Filter`) |
| **Repository** | Arquitetural | Spring Data JPA — abstrai acesso a dados |
| **DTO** | Arquitetural | Separar modelo de banco do modelo exposto na API |

---

## 📋 Progresso Atual

> Status: 🔴 Não iniciada | 🟡 Em andamento | 🟢 Concluída

| Fase | Status | Início | Conclusão |
|---|---|---|---|
| Fase 0: Fundação — Ambiente | 🟢 Concluída | 28/06/2026 | 28/06/2026 |
| Fase 1: CRUD de Processos | 🟢 Concluída | 28/06/2026 | 29/06/2026 |
| Fase 2: Relacionamentos e Validações | 🔴 Não iniciada | — | — |
| Fase 3: Autenticação e Autorização | 🔴 Não iniciada | — | — |
| Fase 4: Upload de Documentos | 🔴 Não iniciada | — | — |
| Fase 5: Workflow — Máquina de Estados | 🔴 Não iniciada | — | — |
| Fase 6: Busca Avançada e Filtros | 🔴 Não iniciada | — | — |
| Fase 7: Cache e Performance | 🔴 Não iniciada | — | — |
| Fase 8: Testes Automatizados | 🔴 Não iniciada | — | — |
| Fase 9: Documentação da API | 🔴 Não iniciada | — | — |
| Fase 10: Mensageria com RabbitMQ | 🔴 Não iniciada | — | — |
| Fase 11: Deploy e CI/CD | 🔴 Não iniciada | — | — |
| Fase 12: Bônus — Microsserviços | 🔴 Não iniciada | — | — |
| Fase 13: Bônus — Interface Web | 🔴 Não iniciada | — | — |

---

## 🧠 Decisões de Arquitetura (ADR)

> Registrar aqui as decisões técnicas importantes e por que foram tomadas.

| # | Data | Decisão | Motivo | Alternativas consideradas |
|---|---|---|---|---|
| 1 | 2026-06-27 | PostgreSQL rodando em container Docker | Ambiente isolado, evita instalar dependências direto no Windows, reproduzível com um comando, aprendizado de Docker já na Fase 0 | Instalação nativa do PostgreSQL no Windows |
| 2 | 2026-06-27 | VS Code como IDE principal (com extensões Java + Spring) | Já está usando, mais leve que IntelliJ IDEA, aprendizado mais explícito | IntelliJ IDEA, Spring Tool Suite |
| 3 | 2026-06-28 | Dockerfile multi-stage (Maven build + JRE runtime) | Imagem final mais leve (~200MB vs ~500MB), separa responsabilidades de build e execução, padrão de mercado para apps Spring Boot | Dockerfile single-stage com JDK completo, build local + copy do jar |
| 4 | 2026-06-28 | Thymeleaf como camada web (Fase 13) | Mesma stack Java, baixa curva de aprendizado, ideal para sistemas administrativos internos. Preparação para realidade de IFES onde não há cargo dedicado de frontend | React, Angular, Vue (overkill para sistemas internos simples) |
| 5 | 2026-06-29 | Exceções customizadas + `@ControllerAdvice` | Service 100% desacoplado de HTTP (não importa `org.springframework.web`). Exceções de negócio puras traduzidas em respostas HTTP pelo `GlobalExceptionHandler` | `ResponseStatusException` no Service (acopla ao protocolo HTTP) |

---

## 🔗 Referências

- [Documentação oficial Spring Boot](https://docs.spring.io/spring-boot/documentation.html)
- [Documentação PostgreSQL](https://www.postgresql.org/docs/)
- [Documentação Docker](https://docs.docker.com/)
- [Documentação Docker Compose](https://docs.docker.com/compose/)
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
- Histórico de sessões e dúvidas nos arquivos: `SESSOES.md` e `DUVIDAS.md`
