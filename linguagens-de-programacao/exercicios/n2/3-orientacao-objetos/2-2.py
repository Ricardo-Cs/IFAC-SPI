class Funcionario:
    def __init__(self, nome, salario):
        self.nome = nome
        self.salario = salario
    
    def calcular_salario_anual(self):
        return self.salario * 12

class Gerente(Funcionario):
    def __init__(self, nome, salario, bonus):
        super().__init__(nome, salario)
        self.bonus = bonus
    
    def calcular_salario_anual(self):
        return (self.salario * 12) + self.bonus

class Vendedor(Funcionario):
    def __init__(self, nome, salario, comissao, vendas):
        super().__init__(nome, salario)
        self.comissao = comissao
        self.vendas = vendas

    def calcular_salario_anual(self):
        return (self.salario * 12) + (self.comissao * self.vendas)

funcionario = Funcionario('José da Silva', 1500)
gerente = Gerente('Silvio Santos', 5000, 2000)
vendedor = Vendedor('Ratinho', 3500, 200, 80)

print(f'Salário Anual do Funcionário: R$ {funcionario.calcular_salario_anual()}')
print(f'Salário Anual do Gerente: R$ {gerente.calcular_salario_anual()}')
print(f'Salário Anual do Vendedor: R$ {vendedor.calcular_salario_anual()}')