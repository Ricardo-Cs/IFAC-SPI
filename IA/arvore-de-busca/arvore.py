# -*- coding: utf-8 -*-
"""
ÁRVORE DE BUSCA — a estrutura de dados.

>>> NÓ != ESTADO <<<
O ESTADO é uma posição do labirinto: (2, 3).
O NÓ é um ponto da árvore: "cheguei em (2,3) vindo de tal pai, por tal ação,
com tal custo, em tal profundidade".

O mesmo estado pode aparecer em vários nós diferentes da árvore — é exatamente
por isso que a árvore explode de tamanho se não controlarmos os visitados.
"""

from problema import sucessores


class No:
    """Um nó da árvore de busca."""

    def __init__(self, estado, pai=None, acao=None):
        self.estado = estado
        self.pai = pai                # de onde viemos (permite reconstruir o caminho)
        self.acao = acao              # que ação nos trouxe até aqui
        self.custo = 0 if pai is None else pai.custo + 1
        self.profundidade = 0 if pai is None else pai.profundidade + 1
        self.filhos = []

        # usados só para a visualização
        self.status = "fronteira"     # fronteira | expandido | podado | objetivo
        self.xi = 0.0                 # coluna horizontal calculada no desenho


def expandir(no):
    """
    EXPANDIR = aplicar todas as ações possíveis ao estado do nó
    e criar um nó FILHO para cada resultado.

    É a única operação que faz a árvore crescer.
    """
    return [No(novo, pai=no, acao=nome) for nome, novo in sucessores(no.estado)]


def caminho(no):
    """
    Sobe pelos ponteiros de pai até a raiz e inverte:
    a SOLUÇÃO é o caminho da raiz até o nó objetivo.
    """
    rota, atual = [], no
    while atual is not None:
        rota.append(atual)
        atual = atual.pai
    rota.reverse()
    return rota
