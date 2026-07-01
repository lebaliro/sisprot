# ❓ Dúvidas

> Registre aqui todas as dúvidas que surgirem durante o desenvolvimento. 
> Use este arquivo como referência para revisão e consolidação do aprendizado.

---

## Formato

```markdown
### [Data] — Título da Dúvida

**Contexto:** (O que estava fazendo quando surgiu a dúvida?)

**Dúvida:** (Pergunta clara e específica)

**Resposta:** (Preencher depois de entender o conceito)

**Aprendizado:** (O que levou dessa dúvida?)
```

---

## Dúvidas

### 30/06/2026 — id: null na resposta do POST de Movimentação

**Contexto:** Criando uma movimentação (POST /api/processos/{id}/movimentacoes). A resposta retorna o objeto criado, mas o campo `id` vem `null`. Porém ao listar (GET), o `id` aparece corretamente.

**Dúvida:** Por que o `id` aparece `null` na resposta do POST se o dado foi salvo no banco? É problema de flush do JPA com CascadeType.ALL e IDENTITY generation?

**Resposta:** O problema é do JPA com cascade + IDENTITY. Ao salvar via `processoRepository.save(processo)`, o cascade propaga para a Movimentacao, mas o ID gerado pelo banco não é populado no objeto original `mov` (comportamento do merge vs persist). A solução foi salvar a Movimentacao explicitamente: `mov = movimentacaoRepository.save(mov)` — o `save()` do Spring Data JPA retorna o objeto com o ID populado.

**Aprendizado:**
- Prefira salvar a entidade filha explicitamente (`repository.save(filho)`) em vez de depender de cascade do pai — fica mais claro e evita surpresas com ID
- Com IDENTITY, o banco gera o ID no INSERT, e o Hibernate popula no objeto retornado pelo `save()`
- Cascade é útil para operações em lote, mas para CRUD simples o explícito é mais seguro

---

### 28/06/2026 — Cargo back-end absorve frontend na UFCA?

**Contexto:** Pesquisando sobre o cargo de Analista de TI / Back-End da UFCA.

**Dúvida:** O cargo é 100% back-end ou vou precisar fazer frontend também?

**Resposta:** O cargo é oficialmente back-end, mas a UFCA **não tem cargo específico de frontend**. Na prática, o analista back-end entrega também interfaces simples. O nível esperado é funcional (tabelas, formulários, CRUD), não design sofisticado.

**Aprendizado:**
- Adicionada **Fase 13 (Thymeleaf + Bootstrap)** ao plano do SISPROT como preparação
- Thymeleaf é a escolha natural: mesma stack Java, templates server-side, baixa curva
- Foco principal segue sendo back-end — uma interface simples se aprende rápido
