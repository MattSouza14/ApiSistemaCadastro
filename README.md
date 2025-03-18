# API de Gerenciamento de Credenciais

Esta API foi desenvolvida em Java com Spring Boot e MySQL para gerenciar as credenciais dos usuários de uma empresa. O objetivo é permitir que os usuários cadastrem e recuperem credenciais que utilizam no dia a dia, como senhas, logins e outras informações sensíveis.

## Tecnologias Utilizadas
- **Java**: Linguagem de programação principal.
- **Spring Boot**: Framework para desenvolvimento de aplicações Java.
- **MySQL**: Banco de dados relacional para armazenamento das credenciais.
- **Maven**: Gerenciador de dependências e build do projeto.

## Endpoints da API

### 1. Listar Todas as Fichas
**Método**: `GET`

**Endpoint**: `/Listar/ListarFichas`

**Descrição**: Retorna uma lista com todas as fichas cadastradas.

**Exemplo de Resposta:**
```json
[
  {
    "id": 1,
    "nome": "João Silva",
    "email": "joao.silva@empresa.com",
    "dataVencimento": "2026-03-03"
  },
  {
    "id": 2,
    "nome": "Maria Souza",
    "email": "maria.souza@empresa.com",
    "dataVencimento": "2025-12-31"
  }
]
```

### 2. Listar Uma Ficha por Email
**Método**: `GET`

**Endpoint**: `/Listar/ListarUmaFicha/{email}`

**Descrição**: Retorna os detalhes de uma ficha específica com base no email.

**Parâmetro**:
- `email` (path): Email do usuário.

**Exemplo de Resposta:**
```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao.silva@empresa.com",
  "dataVencimento": "2026-03-03"
}
```

### 3. Cadastrar uma Nova Ficha
**Método**: `POST`

**Endpoint**: `/Cadastrar/CadastrarFicha`

**Descrição**: Cadastra uma nova ficha de credenciais.

**Corpo da Requisição:**
```json
{
  "nome": "João Silva",
  "email": "joao.silva@empresa.com",
  "dataVencimento": "2026-03-03"
}
```

**Exemplo de Resposta:**
```json
{
  "id": 1,
  "nome": "João Silva",
  "email": "joao.silva@empresa.com",
  "dataVencimento": "2026-03-03"
}
```

### 4. Atualizar uma Ficha Existente
**Método**: `PATCH`

**Endpoint**: `/Atualizar/AtualizarUmaFicha/{email}`

**Descrição**: Atualiza parcialmente os dados de uma ficha existente com base no email.

**Parâmetro**:
- `email` (path): Email do usuário.

**Corpo da Requisição (campos opcionais):**
```json
{
  "nome": "João Silva Atualizado",
  "dataVencimento": "2027-01-01"
}
```

**Exemplo de Resposta:**
```json
{
  "id": 1,
  "nome": "João Silva Atualizado",
  "email": "joao.silva@empresa.com",
  "dataVencimento": "2027-01-01"
}
```

### 5. Deletar uma Ficha
**Método**: `DELETE`

**Endpoint**: `/Deletar/DeletarFicha/{email}`

**Descrição**: Remove uma ficha com base no email.

**Parâmetro**:
- `email` (path): Email do usuário.

**Exemplo de Resposta:**
```json
"Ficha deletada com sucesso para o email: joao.silva@empresa.com"
```

### Pré-requisitos
- **Java 17** ou superior.
- **MySQL** instalado e configurado.
- **Maven** instalado.


