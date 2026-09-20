#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
ÁRVORE DE BUSCA — ponto de entrada.
Apresentação de Algoritmos de Busca em IA — Tema 2

Este arquivo só junta as peças e trata o teclado:

    problema.py  o que é o problema (labirinto, ações, objetivo)
    arvore.py    o que é um NÓ e o que é EXPANDIR
    busca.py     o ALGORITMO (o laço da fronteira)   <-- a parte importante
    visual.py    o desenho em pygame
    main.py      este arquivo: laço de eventos

CONTROLES
  ESPAÇO . expande UM nó (passo a passo)
  A ...... liga/desliga a expansão automática
  V ...... liga/desliga o controle de estados visitados (reinicia)
  R ...... reinicia
  ESC .... sair

Requisito:  pip install pygame
Execute:    python main.py
"""

import sys
import pygame

from busca import Busca
from visual import Visual

INTERVALO_AUTOMATICO = 350   # milissegundos entre passos no modo automático


def main():
    visual = Visual()
    relogio = pygame.time.Clock()

    busca = Busca(usar_visitados=True)
    automatico = False
    ultimo_passo = 0

    while True:
        agora = pygame.time.get_ticks()

        for e in pygame.event.get():
            if e.type == pygame.QUIT:
                pygame.quit(); sys.exit()
            if e.type == pygame.KEYDOWN:
                if e.key in (pygame.K_ESCAPE, pygame.K_q):
                    pygame.quit(); sys.exit()
                elif e.key == pygame.K_SPACE:
                    busca.passo()
                elif e.key == pygame.K_a:
                    automatico = not automatico
                elif e.key == pygame.K_r:
                    busca.reiniciar(); automatico = False
                elif e.key == pygame.K_v:
                    busca.usar_visitados = not busca.usar_visitados
                    busca.reiniciar(); automatico = False

        if automatico and agora - ultimo_passo > INTERVALO_AUTOMATICO:
            busca.passo()
            ultimo_passo = agora
            if busca.terminou():
                automatico = False

        visual.desenhar(busca)
        relogio.tick(60)


if __name__ == "__main__":
    main()
