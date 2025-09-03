# ✅ ToDo List API - Gerenciador de Tarefas

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.4-brightgreen)
![Test Coverage](https://img.shields.io/badge/Testes-TDD%20%2B%20Integração-green)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)

API RESTful para gerenciamento de tarefas, com regras reais de negócio e foco em **qualidade de código**, **testabilidade**, **boas práticas** e **resiliência**.

Este projeto foi idealizado com o objetivo de aplicar **TDD (Desenvolvimento Orientado a Testes)** na prática e aprimorar minhas habilidades em **testes automatizados**. A solução foi propositalmente mantida simples, com apenas uma entidade principal (`Tarefa`) e cenários bem definidos para validação de regras de negócio.

---

## 💡 Funcionalidades

- 📌 Criar tarefas com título e descrição.
- ⏱️ A tarefa inicia com status `CRIADA` e data de criação automática.
- ✅ Atualizar o status da tarefa:
  - `CRIADA → EM_ANDAMENTO → FINALIZADA`
- ⚠️ Apenas uma tarefa pode estar com status `EM_ANDAMENTO` por vez.
- ❌ Ações com IDs inexistentes são bloqueadas com exceções apropriadas.
- 🔁 Listagem com ordenação por data (em desenvolvimento).
- 🧪 Cobertura de testes para todos os fluxos críticos.

---

## 📐 Regras de Negócio

- Título e descrição são obrigatórios.
- A data de criação é gerada automaticamente.
- O status inicial é sempre `CRIADA`.
- Transições válidas:
  - `CRIADA → EM_ANDAMENTO → FINALIZADA`
- **Não é permitido ter mais de uma tarefa em andamento.**
- Operações com IDs inexistentes disparam exceções personalizadas.

---

## 🛠️ Tecnologias Utilizadas

- **Java 21**
- **Spring Boot 3.5.4**
- **Spring Data JPA (H2 in-memory)**
- **JUnit 5 + Mockito**
- **RestAssured** (testes de integração)
- **TDD (Test Driven Development)**
- **Swagger/OpenAPI** *(em desenvolvimento)*

---

## 🧪 Estratégia de Testes

O projeto foi construído seguindo os princípios do TDD:

- ✅ Testes unitários da camada de serviço
- ✅ Testes de integração dos endpoints com RestAssured
- ✅ Cobertura de exceções, validações e regras de negócio

---

## 🧪 Aprendizados 

- Aprimoramento na habilidade de testes (tanto unitários quanto integração);
- Entendimento sobre a metodologia de desenvolvimento TDD, compreendendo o fluxo RED, GREEN, REFACTOR.
- Mundança de pensamento, acompanhando um dos príncipios do TDD é adicionar ao código apenas aquilo que você irá usar, YAGNI ("You Ain't Gonna Need It")
- Maior maturidade ao pensar na resolução do problema antes da implementação no código.

---

## 📁 Estrutura do Projeto

```
com.todo.list
├── controller         # Camada de entrada (REST)
├── service            # Lógica de negócio
├── dto                # DTOs (Request e Response)
├── entity             # Entidade Tarefa
├── enums              # Enum de Status
├── exception          # Exceções e handler global
├── mapper             # Conversão Entity ↔ DTO
├── repository         # Repositório JPA
└── tests              # Testes unitários e de integração
```

---

> ℹ️ Ainda em desenvolvimento. Novas funcionalidades e documentação (Swagger/Postman) serão adicionadas em breve.
