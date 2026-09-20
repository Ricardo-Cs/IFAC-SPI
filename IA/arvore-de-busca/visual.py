# -*- coding: utf-8 -*-
"""
VISUAL (pygame) — só desenho.

Este arquivo NÃO contém nenhuma regra do algoritmo: ele apenas lê o objeto
`Busca` e pinta na tela o que está acontecendo.
É por isso que dá para trocar BFS por DFS sem tocar aqui.

À ESQUERDA: o labirinto (o espaço de estados).
À DIREITA: a árvore de busca sendo construída, nó por nó.
"""

import pygame

from problema import LABIRINTO, LINHAS, COLUNAS
from arvore import caminho
from busca import PROFUNDIDADE_MAXIMA

# ---------------------------------------------------------------------------
# JANELA E CORES
# ---------------------------------------------------------------------------
LARGURA, ALTURA = 1280, 760

FUNDO       = (18, 20, 28)
PAINEL      = (28, 31, 42)
TEXTO       = (232, 234, 240)
TEXTO_FRACO = (150, 155, 170)
PAREDE      = (11, 12, 18)
LIVRE       = (82, 89, 111)
INICIO      = (86, 156, 214)
META        = (106, 191, 105)
VISITADO    = (120, 92, 168)
ATUAL       = (240, 190, 70)
FRONTEIRA   = (90, 100, 130)
PODADO      = (196, 84, 84)
CAMINHO     = (106, 191, 105)
LINHA       = (78, 84, 104)


# ---------------------------------------------------------------------------
# POSICIONAMENTO DA ÁRVORE
# ---------------------------------------------------------------------------
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


class Visual:
    """Guarda a janela e as fontes, e desenha um quadro por chamada."""

    def __init__(self, titulo="Árvore de Busca — Inteligência Artificial"):
        pygame.init()
        self.tela = pygame.display.set_mode((LARGURA, ALTURA))
        pygame.display.set_caption(titulo)
        self.f_titulo = pygame.font.SysFont("dejavusans", 26, bold=True)
        self.f_texto = pygame.font.SysFont("dejavusans", 18)
        self.f_mini = pygame.font.SysFont("dejavusans", 13)

    # -- quadro completo ----------------------------------------------------
    def desenhar(self, busca):
        self.tela.fill(FUNDO)
        self._labirinto(busca)
        self._arvore(busca)
        self._legenda()
        pygame.display.flip()

    # -- painel esquerdo: o espaço de estados -------------------------------
    def _labirinto(self, busca):
        tela, f_texto, f_mini = self.tela, self.f_texto, self.f_mini
        pygame.draw.rect(tela, PAINEL, (0, 0, 400, ALTURA))
        tela.blit(self.f_titulo.render("Espaço de estados", True, TEXTO), (28, 24))
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
        for texto, cor in [
            (f"Controle de visitados: {modo}", TEXTO if busca.usar_visitados else ATUAL),
            (f"Nós gerados: {busca.gerados}", TEXTO),
            (f"Na fronteira: {len(busca.fronteira)}", TEXTO),
            (f"Estados visitados: {len(busca.visitados)}", TEXTO),
        ]:
            tela.blit(f_texto.render(texto, True, cor), (28, y))
            y += 28

        y += 14
        for linha in ["ESPAÇO  expandir um nó", "A  automático", "V  visitados on/off",
                      "R  reiniciar", "ESC  sair"]:
            tela.blit(f_mini.render(linha, True, TEXTO_FRACO), (28, y))
            y += 20

    # -- painel direito: a árvore de busca ----------------------------------
    def _arvore(self, busca):
        tela, f_mini = self.tela, self.f_mini
        tela.blit(self.f_titulo.render("Árvore de busca", True, TEXTO), (436, 24))
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

        # arestas (pai -> filho)
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

        # nós
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

        # régua de níveis
        for d in range(PROFUNDIDADE_MAXIMA + 1):
            yy = int(topo + d * altura_nivel)
            if yy < ALTURA - 70:
                tela.blit(f_mini.render(f"nível {d}", True, TEXTO_FRACO), (LARGURA - 66, yy - 7))

        # barra de mensagem
        pygame.draw.rect(tela, PAINEL, (416, ALTURA - 56, LARGURA - 436, 40), border_radius=8)
        tela.blit(self.f_texto.render(busca.mensagem, True, TEXTO), (436, ALTURA - 46))

    def _legenda(self):
        itens = [("raiz/expandido", VISITADO), ("fronteira", FRONTEIRA),
                 ("atual", ATUAL), ("podado", PODADO), ("objetivo", META)]
        lx = 700
        for nome, cor in itens:
            pygame.draw.circle(self.tela, cor, (lx, 38), 6)
            self.tela.blit(self.f_mini.render(nome, True, TEXTO_FRACO), (lx + 12, 30))
            lx += 20 + self.f_mini.size(nome)[0] + 20
