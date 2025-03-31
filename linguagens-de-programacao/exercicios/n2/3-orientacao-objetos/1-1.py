class Produto:
    def __init__(self, nome, preco, estoque):
        self.nome = nome
        self.preco = preco
        self.estoque = estoque

    def detalhes(self):
        print('\tDetalhes do Produto')
        print(f'Nome: {self.nome}')
        print(f'Preço: {self.preco}')
        print(f'Estoque: {self.estoque}')

produto1 = Produto('Arroz', 20.75, 100)
produto1.detalhes()