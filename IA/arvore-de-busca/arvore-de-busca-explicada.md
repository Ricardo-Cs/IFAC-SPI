# Árvore de Busca — explicação para o grupo

Tema 2 das micro-apresentações de Inteligência Artificial.
A pergunta que precisamos responder é:

> **Como um problema de IA pode ser representado como uma árvore de busca e o que significam seus nós, níveis e ramificações?**

Este arquivo explica tudo do zero, em linguagem simples. Os números usados aqui
são reais: saíram de rodar o nosso próprio `busca.py`.

---

## 1. O labirinto

Este é o mapa que está no `problema.py`, com as coordenadas:

```
        col 0   col 1   col 2   col 3
linha 0   S       .       .       #
linha 1   .       .       #       .
linha 2   #       .       .       .
linha 3   .       #       .       G
```

- `S` = onde começamos, na posição `(0,0)`
- `G` = onde queremos chegar, na posição `(3,3)`
- `#` = parede, não dá para passar
- `.` = chão livre

A pergunta do problema é: **como sair do S e chegar no G?**

---

## 2. O que é "buscar" em IA

O computador não enxerga o labirinto de cima como nós. Ele não "vê" o caminho.
Ele só sabe fazer uma coisa:

> "Estou aqui. Para onde eu consigo ir a partir daqui?"

E aí repete isso. E repete. E repete, até cair no `G`.

**Buscar é isso: testar possibilidades uma por uma até achar a resposta.**
Não tem mágica.

---

## 3. Estado

**Estado = uma situação do problema.**

No labirinto, o estado é simplesmente **onde você está**: `(0,0)`, `(1,2)`, `(2,3)`…

O labirinto tem 16 casas e 4 delas são paredes, então existem
**12 estados possíveis**. É um número pequeno e fixo.

Guarda esse número: **12 estados**. Ele volta no final.

---

## 4. De onde vem a árvore

Comece no `S`, em `(0,0)`, e pergunte: *"para onde dá para ir?"*

| Direção | Destino | Vale? |
|---|---|---|
| Cima | sairia do mapa | não |
| Baixo | `(1,0)`, livre | **sim** |
| Esquerda | sairia do mapa | não |
| Direita | `(0,1)`, livre | **sim** |

Duas opções. Desenhando:

```
                 (0,0)
                /     \
           (1,0)       (0,1)
```

Agora repita a mesma pergunta **para cada uma** das duas. De `(1,0)` dá para ir
a `(0,0)` (voltando) e a `(1,1)`. De `(0,1)` dá para ir a `(1,1)`, a `(0,0)`
(voltando) e a `(0,2)`:

```
                       (0,0)
                      /     \
                 (1,0)       (0,1)
                 /   \      /  |   \
            (0,0)  (1,1) (1,1) (0,0) (0,2)
```

**Isso é a árvore de busca.** Não é nada exótico — é só o desenho de todos os
caminhos que o computador foi testando, um embaixo do outro.

Chama-se árvore porque parece uma árvore de cabeça para baixo: começa num ponto
só e vai se abrindo.

---

## 5. A parte mais importante: NÓ não é ESTADO

Olhe bem o desenho acima. **O `(0,0)` aparece duas vezes na última fileira.**
E o `(1,1)` também aparece duas vezes.

Como assim? Só existe **um** `(0,0)` no labirinto!

Existe um `(0,0)` no *mapa*. Mas na *árvore* ele aparece várias vezes, porque
**dá para chegar no mesmo lugar por caminhos diferentes**.

| | Estado | Nó |
|---|---|---|
| O que é | um lugar no mapa | um lugar **+ a história de como se chegou lá** |
| Exemplo | `(1,1)` | "cheguei em `(1,1)` vindo do `(1,0)`, indo para a direita, depois de 2 passos" |
| Quantos existem | 12, fixo | quantos o computador criar — dezenas, centenas |

Uma analogia: **o estado é um endereço; o nó é uma viagem que terminou naquele
endereço.** Dez pessoas podem chegar na mesma padaria por dez ruas diferentes —
um endereço, dez viagens.

É por isso que no `arvore.py` a classe `No` guarda quatro coisas além do lugar:

```python
self.estado        # onde estou: (1,1)
self.pai           # de onde vim
self.acao          # que movimento me trouxe
self.custo         # quantos passos custou
self.profundidade  # em que nível eu estou
```

O `estado` sozinho seria só o endereço. O resto é a história da viagem.

> **Se for para decorar uma frase da apresentação inteira, é esta: nó não é
> estado. Estado é um lugar; nó é um caminho que terminou nesse lugar.**

---

## 6. Nível (ou profundidade)

O desenho tem fileiras. Cada fileira é um **nível**.

- **Nível 0** — o `S`, antes de dar qualquer passo
- **Nível 1** — tudo que dá para alcançar com **1 passo**
- **Nível 2** — tudo que dá para alcançar com **2 passos**
- **Nível 6** — tudo que dá para alcançar com **6 passos**

**Nível = número de passos dados desde o começo.** É só isso.

No código é a variável `profundidade`, calculada assim:

```python
self.profundidade = 0 if pai is None else pai.profundidade + 1
```

Em português: *"se eu não tenho pai, sou a raiz, nível 0. Se tenho pai, meu
nível é o dele mais um."* Cada passo desce um andar.

Na tela do programa há uma régua escrita `nível 0`, `nível 1`, `nível 2`… do
lado direito. É exatamente isso.

**O nosso `G` está no nível 6** — o caminho mais curto do `S` até ele tem 6 passos.

---

## 7. Ramificação

**Ramificação = quantos filhos um nó gera.**

Quando o computador pergunta "para onde dá para ir daqui?" e a resposta tem 3
opções, aquele nó ganha **3 ramos** saindo dele.

No nosso labirinto isso varia de 2 a 4, porque depende de quantas paredes há em
volta. No `arvore.py` isso é a função:

```python
def expandir(no):
    return [No(novo, pai=no, acao=nome) for nome, novo in sucessores(no.estado)]
```

Ela pega um nó, pergunta ao `problema.py` quais movimentos são válidos e
**cria um nó filho para cada um**.

**É a única função do programa inteiro que faz a árvore crescer.** Se ela não
for chamada, a árvore fica parada.

O nome técnico disso é *fator de ramificação*, e ele é a razão de a busca ser
cara: se cada nó gera 3 filhos, o nível 1 tem 3 nós, o nível 2 tem 9, o nível 3
tem 27 e o nível 6 tem 729. **Multiplica a cada andar.**

---

## 8. A fronteira

Falta uma peça. O computador não expande tudo de uma vez — ele faz um nó por
vez. Então precisa de uma **lista de espera**: os nós que já foram criados mas
ainda não foram abertos.

Isso é a **fronteira**. No `busca.py`:

```python
self.fronteira = [self.raiz]   # começa só com o S
```

E o laço inteiro do algoritmo é este:

1. Tira um nó da fronteira
2. É o objetivo? Então acabou
3. Se não for, expande ele e joga os filhos na fronteira
4. Volta para o passo 1

É literalmente isso. **Todo algoritmo de busca é esse mesmo laço** — BFS, DFS,
A*, todos. A única diferença entre eles é **qual** nó se tira da fronteira no
passo 1 (o mais antigo? o mais novo? o mais barato?). Mas isso é tema dos outros
grupos; não precisamos entrar nisso.

---

## 9. Por que guardar o pai

Quando o computador finalmente cai no `G`, ele achou… um nó. Mas
**a resposta não é o nó, é o caminho**.

Imagine um GPS que dissesse só "chegou", sem dizer por onde ir. Inútil.

Por isso cada nó guarda quem foi o pai dele. Quando acha o `G`, o programa sobe
de pai em pai até a raiz e inverte a lista — é a função `caminho()` do
`arvore.py`:

```python
while atual is not None:
    rota.append(atual)
    atual = atual.pai   # sobe para o pai
rota.reverse()          # inverte: do S até o G
```

É como seguir migalhas de pão de volta. **O caminho é a resposta, e ele só
existe porque cada nó lembra de onde veio.** Essa é a grande vantagem de usar
uma árvore.

---

## 10. O problema: a árvore explode

Volte ao desenho do nível 2. O `(0,0)` estava lá — **o próprio ponto de
partida**, reaparecendo dois passos depois. O computador andou em círculo sem
perceber.

E se ninguém o impedir, ele continua: `(0,0)` → `(0,1)` → `(0,0)` → `(0,1)` →
… para sempre. A árvore cresce infinitamente e nunca termina.

A solução é uma anotação simples: **uma lista de lugares onde já estivemos**. Se
um nó chega num lugar já anotado, corta-se o ramo ali. No `busca.py`:

```python
if self.usar_visitados and no.estado in self.visitados:
    no.status = "podado"
```

Na tela, esses nós ficam **vermelhos**.

Os números reais do nosso programa:

| | Com controle de visitados | Sem |
|---|---|---|
| Nós criados | **22** | **375** |
| Passos até achar | 19 | 159 |
| Resposta encontrada | nível 6 | nível 6 |

**A mesma resposta, com 17 vezes menos trabalho.** E repare: existem só
**12 estados** no labirinto, mas sem o controle o computador criou **375 nós**.
É a prova numérica de que nó ≠ estado.

E isso num labirinto de 16 casas. Num problema de verdade, esses 375 viram bilhões.

---

## 11. Tudo em 6 frases

1. **Estado** é uma situação do problema — aqui, uma posição no labirinto. Existem 12.
2. **Árvore de busca** é o desenho de tudo que o computador testou, ramificando a partir do começo.
3. **Nó** é um ponto da árvore: um lugar **mais** a história de como se chegou nele. Por isso o mesmo lugar vira vários nós.
4. **Nível** é a fileira do nó: quantos passos desde o início.
5. **Ramificação** é quantos filhos um nó gera — as escolhas disponíveis naquele ponto.
6. A árvore serve para **guardar o caminho**, não só o destino; e o preço dela é **crescer rápido demais** se ninguém controlar os lugares já visitados.

---

## 12. Veja acontecendo

```bash
pip install pygame
python main.py
```

Aperte `ESPAÇO` umas dez vezes devagar, olhando o desenho da direita. Tudo que
está escrito aqui acontece na tela — inclusive os nós vermelhos, que são os
lugares repetidos sendo cortados.

| Tecla | O que faz |
|---|---|
| `ESPAÇO` | expande um nó |
| `A` | expansão automática liga/desliga |
| `V` | controle de visitados liga/desliga (**reinicia a busca**) |
| `R` | reinicia |
| `ESC` | sai |

Para ver a árvore explodindo, aperte `V` e deixe rodar no automático com `A`.

---

## Os arquivos do projeto

| Arquivo | O que tem dentro |
|---|---|
| `problema.py` | o labirinto, as ações e o objetivo — nenhum algoritmo |
| `arvore.py` | a classe `No`, a função `expandir()` e a função `caminho()` |
| `busca.py` | o laço da fronteira |
| `visual.py` | só o desenho em pygame, nenhuma regra |
| `main.py` | junta as peças e trata o teclado |
