class Veiculo:
    def __init__(self, tipo):
        self.tipo = tipo
    
    def mover(self):
        print(f'O veículo {self.tipo} está se movendo')

# Herança
class Carro(Veiculo):
    def __init__(self, tipo, modelo):
        super().__init__(tipo)
        self.modelo = modelo

    # Polimorfismo
    def mover(self):
        print(f'O veículo {self.tipo} e modelo {self.modelo} está se movendo')

veiculo1 = Veiculo('Moto')
veiculo1.mover()

veiculo2 = Carro('Carro', 'Fiat')
veiculo2.mover()
