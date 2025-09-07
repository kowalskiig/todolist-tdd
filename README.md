# ToDo List API - Gerenciador de Tarefas

![Java](https://img.shields.io/badge/Java-21-blue)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.4-brightgreen)
![Test Coverage](https://img.shields.io/badge/Testes-TDD%20%2B%20Integração-green)
![Status](https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow)


---

> 🧪 Projeto prático focado em TDD (Desenvolvimento Orientado a Testes), boas práticas de design e regras de negócio reais. Idealizado para consolidar conhecimentos em testes automatizados, estrutura limpa e APIs resilientes.

---

## 📌 Visão Geral

A **ToDo List API** é uma aplicação RESTful para gerenciamento de tarefas. O projeto foi mantido propositalmente simples (com apenas uma entidade principal) para **focar 100% na aplicação correta de TDD, qualidade de código, validações e domínio da lógica de negócio**.

---

## 💡 Funcionalidades

- 📌 Criar tarefas com título e descrição obrigatórios
- ⏱️ Tarefa criada com status padrão `CRIADA` e data automática
- 🔁 Alterar status em ordem obrigatória:
  - `CRIADA → EM_ANDAMENTO → FINALIZADA`
- ⚠️ Apenas uma tarefa pode estar com status `EM_ANDAMENTO` ao mesmo tempo
- ❌ IDs inexistentes disparam exceções personalizadas
- 🗂️ Listagem de tarefas (em desenvolvimento, com ordenação)
- 🧪 Testes automatizados cobrindo 100% dos fluxos críticos

---

## Regras de Negócio

- `título` e `descrição` são obrigatórios
- `status` inicial é sempre `CRIADA`
- `data de criação` gerada automaticamente
- Transições de status obrigam seguir a ordem:
  - `CRIADA → EM_ANDAMENTO → FINALIZADA`
- Só é permitida **uma única tarefa em andamento**
- Ações inválidas ou com ID inexistente lançam exceções claras e tratadas

---

## 🧪 Estratégia de Testes

O projeto segue a risca o fluxo de TDD: **RED → GREEN → REFACTOR**

- ✅ Testes unitários na camada de serviço
- ✅ Testes de integração com `RestAssured`
- ✅ Cobertura de regras de negócio e exceções
- ✅ Assertivas claras e orientadas a comportamento esperado

---

## 📚 Aprendizados Técnicos

- Aplicação prática do ciclo TDD completo
- Pensamento em regras de negócio antes do código
- Melhoria na escrita de testes robustos e legíveis
- Princípios de **YAGNI** (You Ain’t Gonna Need It)
- Princípios de desenvolvimento ágil como **YAGNI**, **DRY**, **KISS** e **Baby steps**
- Projeto 100% dirigido por cenários reais e validações de negócio
- Maturidade na separação de responsabilidades (DTOs, mappers, service, etc.)

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


---

## 🚧 Status

> Projeto em desenvolvimento — próximas entregas incluem:
- Documentação Swagger/OpenAPI
- Filtro de listagem por status e ordenação
- Deploy via Docker (CI/CD)

---

## 👨‍💻 Autor

**Gustavo Eiji Kowalski Hatada**  
[![LinkedIn Badge](https://img.shields.io/badge/-Gustavo%20Kowalski-blue?style=flat&logo=Linkedin&logoColor=white)](https://www.linkedin.com/in/gustavokowalski/)

---

> 💬 Projeto voltado para reforçar habilidades práticas em TDD, organização por camadas, validações robustas e responsabilidade única. Mesmo sendo simples, entrega alta qualidade técnica e reflete conhecimento real do processo de desenvolvimento profissional.
