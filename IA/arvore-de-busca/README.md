# Árvore de Busca — apresentação

## Ordem sugerida para apresentar

| # | Arquivo | O que mostrar |
|---|---------|---------------|
| 1 | `problema.py` | O problema formalizado: estado, ações, objetivo. ~40 linhas, sem algoritmo nenhum. |
| 2 | `arvore.py` | **NÓ != ESTADO.** A classe `No` e a função `expandir` — a única operação que faz a árvore crescer. |
| 3 | `busca.py` | **A parte principal.** O laço da fronteira, o teste de objetivo, a poda por estado repetido. O método `retirar()` é a linha que define se é BFS, DFS ou A*. |
| 4 | `visual.py` | Só pygame, nenhuma regra do algoritmo. Pode ser pulado na apresentação. |
| 5 | `main.py` | Laço de eventos / teclado. |

## Executar

```bash
pip install pygame
python main.py
```

## Controles

- `ESPAÇO` — expande **um** nó (modo passo a passo)
- `A` — expansão automática liga/desliga
- `V` — controle de estados visitados liga/desliga (reinicia — ótimo para mostrar a árvore explodindo)
- `R` — reinicia
- `ESC` — sair

## Demonstração-chave

Rode com `V` **desligado** e mostre a árvore explodindo: o mesmo estado reaparece
em dezenas de nós diferentes. Depois ligue `V` e mostre a mesma busca terminando
em 19 passos.

> `arvore-de-busca.py` é a versão original em arquivo único, mantida só como referência.
