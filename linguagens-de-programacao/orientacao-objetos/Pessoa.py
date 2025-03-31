class Pessoa:
    def __init__(self, nome, idade):
        self.nome = nome
        self.idade = idade
    
    def apresentar(self):
        print(f'Nome: {self.nome}\nIdade: {self.idade}\n')

pessoa1 = Pessoa('Ricardo', 18)
pessoa1.apresentar()
