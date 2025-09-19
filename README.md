#  ToDo List API - Gerenciador de Tarefas

Aplicação RESTful para gerenciamento de tarefas com foco total em **TDD (Desenvolvimento Orientado a Testes)**, qualidade de código e domínio da lógica de negócio. Criado para consolidar boas práticas em testes, design limpo e regras reais de negócio.

Objetivo reforçar habilidades em **TDD**, **design limpo**, **validações sólidas** e construção de API com foco em qualidade técnica, além de aplicar conceitos ágeis no desenvolvimento backend.

<p align="center">
  <a href="https://skillicons.dev">
    <img src="https://skillicons.dev/icons?i=java,spring,postgresql" />
  </a>
</p>
<p align="center">
  <img src="https://img.shields.io/badge/Cobertura-100%25-brightgreen?style=for-the-badge&logo=pytest" />
  <img src="https://img.shields.io/badge/Status-Em%20Desenvolvimento-yellow?style=for-the-badge" />
</p>


## Visão geral do projeto

A **ToDo List API** é uma aplicação simples e direta, com apenas uma entidade principal (`Tarefa`), idealizada para **aplicação 100% baseada em TDD**, com testes de unidade, integração e regras de negócio explícitas.

##  Funcionalidades

-  Criar tarefas com título e descrição obrigatórios  
-  Data de criação gerada automaticamente  
-  Alterar status em ordem obrigatória:  
  `CRIADA → EM_ANDAMENTO → FINALIZADA`  
-  Apenas uma tarefa pode estar com status `EM_ANDAMENTO` ao mesmo tempo  
-  IDs inexistentes disparam exceções personalizadas  
-  Listagem de tarefas (com ordenação e filtros - em desenvolvimento)  

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

Projeto desenvolvido com ciclo completo de TDD: `RED → GREEN → REFACTOR`

-  Testes unitários na camada de serviço ✔️  
- Testes de integração com `RestAssured` ✔️  
- Cobertura de regras de negócio e exceções ✔️  
- Assertivas claras orientadas ao comportamento esperado ✔️ 

## 📚 Aprendizados Técnicos

- Aplicação real do ciclo **TDD** completo ✔️ 
- Pensamento em regras de negócio antes do código ✔️ 
- Escrita de testes robustos e legíveis ✔️ 
- Princípios ágeis aplicados: `YAGNI`, `DRY`, `KISS`, `Baby Steps` ✔️ 
- Projeto voltado à **responsabilidade única** e separação em camadas ✔️ 

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


📬 Conecte-se comigo 
  <a href="https://www.linkedin.com/in/gustavokowalski/" target="_blank">LinkedIn</a> | 
  <a href="mailto:kkowalskigustavo@gmail.com">Email</a>



