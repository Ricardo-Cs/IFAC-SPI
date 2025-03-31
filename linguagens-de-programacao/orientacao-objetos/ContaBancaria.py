class ContaBancaria:
    def __init__(self, titular, num_conta, agencia):
        self.titular = titular
        self.num_conta = num_conta
        self.agencia = agencia
        self.saldo = 0.0

    def depositar(self, valor):
        self.saldo += valor
        print(f'Depósito de R$ {valor} na conta de {self.titular}\n')

    def mostrarDados(self):
        print('-------------------------------------')
        print('Titular: ', self.titular)
        print('Número da conta: ', self.num_conta)
        print('Agência: ', self.agencia)
        print('Saldo: R$', self.saldo)
        print('-------------------------------------\n')

    def sacar(self, valor):
        if valor > self.saldo:
            print(f'Saldo insuficiente para saque na conta de {self.titular}\n')
        else: 
            self.saldo -= valor
            print(f'Saque de R$ {valor} na conta de {self.titular}\n')

conta1 = ContaBancaria('Ricardo Costa da Silva', 2012, 3560)
conta1.mostrarDados()
conta1.depositar(5000.20)
conta1.mostrarDados()
conta1.sacar(300.75)
conta1.mostrarDados()
