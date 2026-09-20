# Microservice NestJS + Python (FastAPI)

Projeto de exemplo demonstrando uma **arquitetura de microsserviços** com comunicação HTTP entre um gateway **NestJS** (Node.js) e um microsserviço **FastAPI** (Python), orquestrados via **Docker Compose**.

---

## Arquitetura

```
┌────────────────────┐         HTTP POST         ┌────────────────────┐
│                    │    /process { value: N }   │                    │
│    api-nest        │ ────────────────────────►  │    ms-python       │
│    (NestJS)        │                            │    (FastAPI)       │
│    porta 3000      │ ◄────────────────────────  │    porta 8000      │
│                    │    { result: N * 2 }       │                    │
└────────────────────┘                            └────────────────────┘
        ▲
        │  HTTP GET /test?value=N
        │
      Cliente
```

### Fluxo de funcionamento

1. O cliente faz uma requisição `GET /test?value=5` para a API NestJS (porta `3000`).
2. O NestJS recebe o valor e faz um `POST` interno para o microsserviço Python em `http://ms-python:8000/process` com o body `{ "value": 5 }`.
3. O microsserviço Python multiplica o valor por **2** e retorna `{ "result": 10 }`.
4. O NestJS repassa a resposta ao cliente.

---

## Estrutura do Projeto

```
microservice-nest/
├── docker-compose.yml          # Orquestração dos containers
├── README.md                   # Este arquivo
│
├── api-nest/                   # API Gateway (NestJS)
│   ├── Dockerfile
│   ├── package.json
│   ├── tsconfig.json
│   └── src/
│       ├── main.ts             # Bootstrap da aplicação (porta 3000)
│       ├── app.module.ts       # Módulo raiz (importa PythonModule)
│       ├── app.controller.ts   # GET / → "Hello World!"
│       ├── app.service.ts      # Service padrão
│       └── python/
│           ├── python.module.ts      # Módulo com HttpModule
│           ├── python.controller.ts  # GET /test?value=N
│           └── python.service.ts     # POST para ms-python
│
└── ms-python/                  # Microsserviço Python (FastAPI)
    ├── Dockerfile
    ├── requirements.txt        # fastapi, uvicorn
    └── app/
        └── main.py             # POST /process → value * 2
```

---

## Pré-requisitos

- [Docker](https://www.docker.com/get-started) instalado
- [Docker Compose](https://docs.docker.com/compose/install/) instalado

> Para rodar **sem Docker**, você precisa também de:
>
> - [Node.js 20+](https://nodejs.org/)
> - [Python 3.11+](https://www.python.org/)

---

## Como rodar

### Com Docker Compose (recomendado)

```bash
# Na raiz do projeto
docker-compose up --build
```

Isso irá:

- Construir a imagem do **api-nest** (Node.js 20 + NestJS)
- Construir a imagem do **ms-python** (Python 3.11 + FastAPI)
- Subir ambos os containers com a rede interna do Docker

Para rodar em segundo plano:

```bash
docker-compose up --build -d
```

Para parar os containers:

```bash
docker-compose down
```

---

### Sem Docker (desenvolvimento local)

#### 1. Microsserviço Python

```bash
cd ms-python
pip install -r requirements.txt
uvicorn app.main:app --host 0.0.0.0 --port 8000
```

#### 2. API NestJS

> **Atenção:** ao rodar localmente, a URL do microsserviço Python precisa ser alterada de `http://ms-python:8000` para `http://localhost:8000` no arquivo `api-nest/src/python/python.service.ts`.

```bash
cd api-nest
npm install
npm run start:dev
```

---

## Endpoints

### API NestJS (porta 3000)

| Método | Rota            | Descrição                                               |
| ------ | --------------- | ------------------------------------------------------- |
| GET    | `/`             | Retorna `Hello World!`                                  |
| GET    | `/test?value=N` | Envia `N` ao microsserviço Python e retorna o resultado |

### Microsserviço Python (porta 8000)

| Método | Rota       | Body             | Descrição                     |
| ------ | ---------- | ---------------- | ----------------------------- |
| POST   | `/process` | `{ "value": N }` | Retorna `{ "result": N * 2 }` |

---

## Exemplos de uso

### Teste rápido via navegador

```
http://localhost:3000/test?value=5
```

Resposta esperada:

```json
{ "result": 10 }
```

### Teste via cURL

```bash
# Hello World
curl http://localhost:3000/

# Processamento via microsserviço Python
curl "http://localhost:3000/test?value=7"
# Resposta: { "result": 14 }

# Chamada direta ao microsserviço Python
curl -X POST http://localhost:8000/process \
  -H "Content-Type: application/json" \
  -d '{"value": 3}'
# Resposta: { "result": 6 }
```

---

## Tecnologias

| Serviço      | Tecnologia            | Versão |
| ------------ | --------------------- | ------ |
| api-nest     | NestJS + TypeScript   | v11    |
| api-nest     | Node.js               | 20     |
| api-nest     | Axios (@nestjs/axios) | v4     |
| ms-python    | FastAPI               | latest |
| ms-python    | Uvicorn               | latest |
| ms-python    | Python                | 3.11   |
| Orquestração | Docker Compose        | v3.9   |
