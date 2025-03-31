class Veiculo:
    def __init__(self, marca, modelo, ano):
        self.marca = marca
        self.modelo = modelo
        self.ano = ano
    
    def exibir_detalhes(self):
        print('\n\tDetalhes do Veículo')
        print(f'Marca: {self.marca}')
        print(f'Modelo: {self.modelo}')
        print(f'Ano: {self.ano}')

class Carro(Veiculo):
    def __init__(self, marca, modelo, ano, tipo_combustivel):
        super().__init__(marca, modelo, ano)
        self.tipo_commbustivel = tipo_combustivel

    def exibir_detalhes(self):
        super().exibir_detalhes()
        print(f'Tipo de Combustível: {self.tipo_commbustivel}')
    

class Moto(Veiculo):
    def __init__(self, marca, modelo, ano, cilindradas):
        super().__init__(marca, modelo, ano)
        self.cilindradas = cilindradas

    def exibir_detalhes(self):
        super().exibir_detalhes()
        print(f'Cilindradas: {self.cilindradas}')

carro = Carro('Toyota', 'Corolla', 2022, 'Gasolina')
moto = Moto('Honda', 'CB 500', 2021, '500cc')

carro.exibir_detalhes()
moto.exibir_detalhes()