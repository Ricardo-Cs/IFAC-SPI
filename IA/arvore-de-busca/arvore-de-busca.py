#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
ÁRVORE DE BUSCA — versão visual (pygame)
Apresentação de Algoritmos de Busca em IA — Tema 2

À ESQUERDA: o labirinto (o espaço de estados).
À DIREITA: a árvore de busca sendo construída, nó por nó, ao vivo.

CONTROLES
  ESPAÇO . expande UM nó (passo a passo)
  A ...... liga/desliga a expansão automática
  V ...... liga/desliga o controle de estados visitados  (reinicia)
  R ...... reinicia
  ESC .... sair

Requisito:  pip install pygame
Execute:    python3 arvore_de_busca_visual.py
"""

import sys
import pygame

# ---------------------------------------------------------------------------
# O PROBLEMA
# ---------------------------------------------------------------------------
LABIRINTO = [
    "S..#",
    "..#.",
    "#...",
    ".#.G",
]

ACOES = [
    ("Cima",     -1,  0),
    ("Baixo",     1,  0),
    ("Esquerda",  0, -1),
    ("Direita",   0,  1),
]

LINHAS, COLUNAS = len(LABIRINTO), len(LABIRINTO[0])
PROFUNDIDADE_MAXIMA = 7   # trava de segurança quando os visitados estão DESLIGADOS


def encontrar(simbolo):
    for i in range(LINHAS):
        for j in range(COLUNAS):
            if LABIRINTO[i][j] == simbolo:
                return (i, j)
    raise ValueError(simbolo)


INICIAL, OBJETIVO = encontrar("S"), encontrar("G")


def valido(estado):
    i, j = estado
    return 0 <= i < LINHAS and 0 <= j < COLUNAS and LABIRINTO[i][j] != "#"


# ---------------------------------------------------------------------------
# O NÓ  (nó != estado: o nó guarda de onde veio)
# ---------------------------------------------------------------------------
class No:
    def __init__(self, estado, pai=None, acao=None):
        self.estado = estado
        self.pai = pai
        self.acao = acao
        self.custo = 0 if pai is None else pai.custo + 1
        self.profundidade = 0 if pai is None else pai.profundidade + 1
        self.filhos = []
        self.status = "fronteira"   # fronteira | expandido | podado | objetivo
        self.xi = 0.0               # posição horizontal calculada no desenho


def expandir(no):
    filhos = []
    for nome, di, dj in ACOES:
        novo = (no.estado[0] + di, no.estado[1] + dj)
        if valido(novo):
            filhos.append(No(novo, pai=no, acao=nome))
    return filhos


def caminho(no):
    rota, atual = [], no
    while atual is not None:
        rota.append(atual)
        atual = atual.pai
    rota.reverse()
    return rota


# ---------------------------------------------------------------------------
# ESTADO DA BUSCA
# ---------------------------------------------------------------------------
class Busca:
    def __init__(self, usar_visitados=True):
        self.usar_visitados = usar_visitados
        self.reiniciar()

    def reiniciar(self):
        self.raiz = No(INICIAL)
        self.fronteira = [self.raiz]
        self.visitados = set()
        self.gerados = 1
        self.atual = None
        self.solucao = None
        self.mensagem = "Pressione ESPAÇO para expandir o primeiro nó."

    def passo(self):
        """Expande exatamente um nó. É aqui que a árvore cresce."""
        if self.solucao or not self.fronteira:
            return
        no = self.fronteira.pop(0)   # <-- TROCAR ESTA LINHA = OUTRO ALGORITMO
        self.atual = no

        if no.estado == OBJETIVO:
            no.status = "objetivo"
            self.solucao = no
            self.mensagem = f"Objetivo achado no nível {no.profundidade}, custo {no.custo}."
            return

        if self.usar_visitados and no.estado in self.visitados:
            no.status = "podado"
            self.mensagem = f"{no.estado} já foi visitado -> ramo podado."
            return

        if no.profundidade >= PROFUNDIDADE_MAXIMA:
            no.status = "podado"
            self.mensagem = f"Limite de profundidade {PROFUNDIDADE_MAXIMA} atingido."
            return

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


# ---------------------------------------------------------------------------
# CORES E JANELA
# ---------------------------------------------------------------------------
LARGURA, ALTURA = 1280, 760
FUNDO       = (18, 20, 28)
PAINEL      = (28, 31, 42)
TEXTO       = (232, 234, 240)
TEXTO_FRACO = (150, 155, 170)
PAREDE      = (58, 62, 78)
LIVRE       = (70, 76, 96)
INICIO      = (86, 156, 214)
META        = (106, 191, 105)
VISITADO    = (120, 92, 168)
ATUAL       = (240, 190, 70)
FRONTEIRA   = (90, 100, 130)
PODADO      = (196, 84, 84)
CAMINHO     = (106, 191, 105)
LINHA       = (78, 84, 104)


def layout(no, contador):
    """Dá a cada folha uma coluna; cada pai fica centralizado sobre seus filhos."""
    if not no.filhos:
        no.xi = contador[0]
        contador[0] += 1
    else:
        for f in no.filhos:
            layout(f, contador)
        no.xi = (no.filhos[0].xi + no.filhos[-1].xi) / 2


def cor_do_no(no, busca):
    if no is busca.atual:
        return ATUAL
    if no.status == "objetivo":
        return META
    if no.status == "podado":
        return PODADO
    if no.status == "expandido":
        return INICIO if no.pai is None else VISITADO
    return FRONTEIRA


def desenhar(tela, busca, f_titulo, f_texto, f_mini):
    """Desenha o quadro inteiro: labirinto à esquerda, árvore à direita."""
    tela.fill(FUNDO)

    # ---------------- painel esquerdo: labirinto ----------------
    pygame.draw.rect(tela, PAINEL, (0, 0, 400, ALTURA))
    tela.blit(f_titulo.render("Espaço de estados", True, TEXTO), (28, 24))
    tela.blit(f_mini.render("o mapa do problema", True, TEXTO_FRACO), (28, 56))

    celula, ox, oy = 76, 44, 92
    rota = [n.estado for n in caminho(busca.solucao)] if busca.solucao else []
    for i in range(LINHAS):
        for j in range(COLUNAS):
            r = pygame.Rect(ox + j * celula, oy + i * celula, celula - 6, celula - 6)
            simbolo = LABIRINTO[i][j]
            cor = PAREDE if simbolo == "#" else LIVRE
            if (i, j) in busca.visitados:
                cor = VISITADO
            if (i, j) in rota:
                cor = CAMINHO
            if busca.atual and busca.atual.estado == (i, j):
                cor = ATUAL
            pygame.draw.rect(tela, cor, r, border_radius=8)
            if simbolo in ("S", "G"):
                borda = INICIO if simbolo == "S" else META
                pygame.draw.rect(tela, borda, r, width=3, border_radius=8)
                tela.blit(f_texto.render(simbolo, True, TEXTO), (r.x + 8, r.y + 6))
            tela.blit(f_mini.render(f"{i},{j}", True, TEXTO_FRACO),
                      (r.x + r.w - 26, r.y + r.h - 18))

    y = oy + LINHAS * celula + 24
    modo = "LIGADO" if busca.usar_visitados else "DESLIGADO"
    painel_txt = [
        (f"Controle de visitados: {modo}", ATUAL if not busca.usar_visitados else TEXTO),
        (f"Nós gerados: {busca.gerados}", TEXTO),
        (f"Na fronteira: {len(busca.fronteira)}", TEXTO),
        (f"Estados visitados: {len(busca.visitados)}", TEXTO),
    ]
    for texto, cor in painel_txt:
        tela.blit(f_texto.render(texto, True, cor), (28, y)); y += 28

    y += 14
    for linha in ["ESPAÇO  expandir um nó", "A  automático", "V  visitados on/off",
                  "R  reiniciar", "ESC  sair"]:
        tela.blit(f_mini.render(linha, True, TEXTO_FRACO), (28, y)); y += 20

    # ---------------- painel direito: árvore ----------------
    tela.blit(f_titulo.render("Árvore de busca", True, TEXTO), (436, 24))
    tela.blit(f_mini.render("o registro do que o algoritmo explorou", True, TEXTO_FRACO),
              (436, 56))

    contador = [0]
    layout(busca.raiz, contador)
    folhas = max(1, contador[0])
    area_x, area_largura = 436, LARGURA - 436 - 96
    espaco = min(96, area_largura / (folhas + 0.5))
    raio = max(7, min(20, int(espaco * 0.34)))
    altura_nivel = min(92, (ALTURA - 180) / max(1, PROFUNDIDADE_MAXIMA))
    topo = 100

    def pos(no):
        return (int(area_x + (no.xi + 0.5) * espaco),
                int(topo + no.profundidade * altura_nivel))

    rota_nos = set(id(n) for n in caminho(busca.solucao)) if busca.solucao else set()

    pilha = [busca.raiz]
    while pilha:
        no = pilha.pop()
        px, py = pos(no)
        for f in no.filhos:
            fx, fy = pos(f)
            destaque = id(f) in rota_nos and id(no) in rota_nos
            pygame.draw.line(tela, CAMINHO if destaque else LINHA,
                             (px, py), (fx, fy), 3 if destaque else 1)
            pilha.append(f)

    pilha = [busca.raiz]
    while pilha:
        no = pilha.pop()
        px, py = pos(no)
        pygame.draw.circle(tela, cor_do_no(no, busca), (px, py), raio)
        if id(no) in rota_nos:
            pygame.draw.circle(tela, CAMINHO, (px, py), raio + 3, 2)
        if raio >= 13:
            rot = f_mini.render(f"{no.estado[0]},{no.estado[1]}", True, (14, 16, 22))
            tela.blit(rot, (px - rot.get_width() // 2, py - rot.get_height() // 2))
        pilha.extend(no.filhos)

    for d in range(PROFUNDIDADE_MAXIMA + 1):
        yy = int(topo + d * altura_nivel)
        if yy < ALTURA - 70:
            tela.blit(f_mini.render(f"nível {d}", True, TEXTO_FRACO), (LARGURA - 66, yy - 7))

    pygame.draw.rect(tela, PAINEL, (416, ALTURA - 56, LARGURA - 436, 40), border_radius=8)
    tela.blit(f_texto.render(busca.mensagem, True, TEXTO), (436, ALTURA - 46))

    legenda = [("raiz/expandido", VISITADO), ("fronteira", FRONTEIRA),
               ("atual", ATUAL), ("podado", PODADO), ("objetivo", META)]
    lx = 700
    for nome, cor in legenda:
        pygame.draw.circle(tela, cor, (lx, 38), 6)
        tela.blit(f_mini.render(nome, True, TEXTO_FRACO), (lx + 12, 30))
        lx += 20 + f_mini.size(nome)[0] + 20



def main():
    pygame.init()
    tela = pygame.display.set_mode((LARGURA, ALTURA))
    pygame.display.set_caption("Árvore de Busca — Inteligência Artificial")
    relogio = pygame.time.Clock()
    f_titulo = pygame.font.SysFont("dejavusans", 26, bold=True)
    f_texto = pygame.font.SysFont("dejavusans", 18)
    f_mini = pygame.font.SysFont("dejavusans", 13)

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

        if automatico and agora - ultimo_passo > 350:
            busca.passo()
            ultimo_passo = agora
            if busca.solucao or not busca.fronteira:
                automatico = False

        desenhar(tela, busca, f_titulo, f_texto, f_mini)
        pygame.display.flip()
        relogio.tick(60)


if __name__ == "__main__":
    main()