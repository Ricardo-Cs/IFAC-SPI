class Aluno:
    def __init__(self, nome, idade, curso):
        self.nome = nome
        self.idade = idade
        self.curso = curso
    
    def exibir_dados(self):
        print('\n\tDados do Aluno')
        print(f'Nome: {self.nome}')
        print(f'Idade: {self.idade}')
        print(f'Curso: {self.curso}')

aluno1 = Aluno('Ricardo Costa', 19, 'Sistemas para Internet')
aluno2 = Aluno('Victor Silva', 22, 'Administração')

aluno1.exibir_dados()
aluno2.exibir_dados()