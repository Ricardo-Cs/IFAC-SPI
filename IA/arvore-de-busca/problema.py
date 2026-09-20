# -*- coding: utf-8 -*-
"""
PROBLEMA — a definição formal do que queremos resolver.

Um problema de busca é sempre a mesma tupla:
    (estado inicial, ações, modelo de transição, teste de objetivo, custo)

Aqui o problema é um labirinto: o estado é a posição (linha, coluna).
Nada neste arquivo sabe o que é uma árvore ou um algoritmo de busca.
"""

LABIRINTO = [
    "S..#",
    "..#.",
    "#...",
    ".#.G",
]

# As AÇÕES possíveis e o deslocamento que cada uma provoca.
ACOES = [
    ("Cima",     -1,  0),
    ("Baixo",     1,  0),
    ("Esquerda",  0, -1),
    ("Direita",   0,  1),
]

LINHAS, COLUNAS = len(LABIRINTO), len(LABIRINTO[0])


def encontrar(simbolo):
    """Localiza um símbolo ('S' ou 'G') no mapa."""
    for i in range(LINHAS):
        for j in range(COLUNAS):
            if LABIRINTO[i][j] == simbolo:
                return (i, j)
    raise ValueError(simbolo)


INICIAL = encontrar("S")    # estado inicial
OBJETIVO = encontrar("G")   # teste de objetivo: estado == OBJETIVO


def valido(estado):
    """Modelo de transição: o estado existe e não é parede?"""
    i, j = estado
    return 0 <= i < LINHAS and 0 <= j < COLUNAS and LABIRINTO[i][j] != "#"


def sucessores(estado):
    """Devolve [(nome_da_acao, novo_estado), ...] a partir de um estado."""
    saida = []
    for nome, di, dj in ACOES:
        novo = (estado[0] + di, estado[1] + dj)
        if valido(novo):
            saida.append((nome, novo))
    return saida
