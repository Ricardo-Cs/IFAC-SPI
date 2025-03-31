class Instrumento:
    def __init__(self, nome):
        self.nome = nome

    def tocar(self):
        print('Tocando um som genérico.')

class Violao(Instrumento):
    def tocar(self):
        print('Tocando acordes no violão.')

class Flauta(Instrumento):
    def tocar(self):
        print('Tocando uma melodia na Flauta.')

instrumento = Instrumento('Instrumento')
violao = Violao('Violão')
flauta = Flauta('Flauta')

instrumento.tocar()
violao.tocar()
flauta.tocar()