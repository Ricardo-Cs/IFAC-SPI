# -*- coding: utf-8 -*-
"""
O ALGORITMO DE BUSCA — o coração da apresentação.

Todo algoritmo de busca em árvore é este mesmo laço:

    fronteira = [raiz]
    enquanto a fronteira não estiver vazia:
        nó = retira um nó da fronteira      <-- QUEM é retirado define o algoritmo
        se nó é objetivo: acabou
        expande o nó e joga os filhos na fronteira

Aqui o laço está quebrado em passos (método `passo`) para que a interface
consiga mostrar UM nó sendo expandido de cada vez.
"""

from problema import INICIAL, OBJETIVO
from arvore import No, expandir

PROFUNDIDADE_MAXIMA = 7   # trava de segurança quando os visitados estão DESLIGADOS


class Busca:
    def __init__(self, usar_visitados=True):
        self.usar_visitados = usar_visitados
        self.reiniciar()

    def reiniciar(self):
        self.raiz = No(INICIAL)         # a árvore começa com um único nó
        self.fronteira = [self.raiz]    # nós gerados mas ainda não expandidos
        self.visitados = set()          # ESTADOS já expandidos (não nós!)
        self.gerados = 1
        self.atual = None
        self.solucao = None
        self.mensagem = "Pressione ESPAÇO para expandir o primeiro nó."

    def retirar(self):
        """
        A ÚNICA linha que diferencia os algoritmos:

            pop(0)  -> FILA        -> Busca em LARGURA  (BFS)
            pop()   -> PILHA       -> Busca em PROFUNDIDADE (DFS)
            menor f -> FILA DE PRIORIDADE -> Custo Uniforme / A*

        A árvore, o nó e a expansão continuam exatamente os mesmos.
        """
        return self.fronteira.pop(0)

    def passo(self):
        """Expande exatamente UM nó. É aqui que a árvore cresce."""
        if self.solucao or not self.fronteira:
            return

        no = self.retirar()
        self.atual = no

        # 1) teste de objetivo — feito ao RETIRAR o nó, não ao gerá-lo
        if no.estado == OBJETIVO:
            no.status = "objetivo"
            self.solucao = no
            self.mensagem = f"Objetivo achado no nível {no.profundidade}, custo {no.custo}."
            return

        # 2) estado repetido — poda o ramo (evita explorar o mesmo lugar de novo)
        if self.usar_visitados and no.estado in self.visitados:
            no.status = "podado"
            self.mensagem = f"{no.estado} já foi visitado -> ramo podado."
            return

        # 3) trava de profundidade — sem controle de visitados a árvore é infinita
        if no.profundidade >= PROFUNDIDADE_MAXIMA:
            no.status = "podado"
            self.mensagem = f"Limite de profundidade {PROFUNDIDADE_MAXIMA} atingido."
            return

        # 4) EXPANSÃO: o nó vira pai, os filhos entram na fronteira
        self.visitados.add(no.estado)
        no.status = "expandido"
        for filho in expandir(no):
            no.filhos.append(filho)
            self.fronteira.append(filho)
            self.gerados += 1

        self.mensagem = f"Expandiu {no.estado}: gerou {len(no.filhos)} filhos."
        if not self.usar_visitados:
            repetidos = sum(1 for f in no.filhos if f.estado in self.visitados)
            if repetidos:
                self.mensagem += f"  {repetidos} deles já apareceram antes!"

    def terminou(self):
        return self.solucao is not None or not self.fronteira
