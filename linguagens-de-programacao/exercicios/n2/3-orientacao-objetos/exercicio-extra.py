class Livro:
    def __init__(self, titulo, autor, isbn):
        self.titulo = titulo
        self.autor = autor
        self.isbn = isbn
        self.disponivel = True
    
    def isDisponivel(self):
        if self.disponivel:
            self.disponivel = False
            return True
        return False
    
    def devolver(self):
        self.disponivel = True

class Usuario:
    def __init__(self, nome):
        self.nome = nome
        self.livros_emprestados = []
    
    def pegar_emprestado(self, livro):
        if livro.isDisponivel():
            self.livros_emprestados.append(livro)
            print(f"\n{self.nome} pegou emprestado o livro '{livro.titulo}'.")
        else:
            print(f"\nO livro '{livro.titulo}' não está disponível.")
    
    def devolver_livro(self, livro):
        if livro in self.livros_emprestados:
            livro.devolver()
            self.livros_emprestados.remove(livro)
            print(f"\n{self.nome} devolveu o livro '{livro.titulo}'.")
        else:
            print(f"\n{self.nome} não possui esse livro emprestado.")

class Bibliotecario:
    def __init__(self, nome):
        self.nome = nome
    
    def adicionar_livro(self, titulo, autor, isbn, biblioteca):
        livro = Livro(titulo, autor, isbn)
        biblioteca.append(livro)
        print(f"Livro '{titulo}' adicionado à biblioteca.")
    
    def listar_livros(self, biblioteca):
        print('\n\tLivros na Biblioteca')
        for i, livro in enumerate(biblioteca, start=1):
            print(f'{i}. {livro.titulo} ({livro.autor}) - {"Disponível" if livro.disponivel else "Emprestado"}')


biblioteca = []
bibliotecario = Bibliotecario('Judite')
usuario = Usuario('Ricardo')

bibliotecario.adicionar_livro('Duna', 'Frank Herbert', 1111111, biblioteca)
bibliotecario.adicionar_livro('Frankenstein', 'Mary Shelley', 2222222, biblioteca)
bibliotecario.adicionar_livro('O Assassinato No Expresso Oriente', 'Agatha Christie', 3333333, biblioteca)
bibliotecario.adicionar_livro('1984', 'George Orwell', 4444444, biblioteca)

bibliotecario.listar_livros(biblioteca)

usuario.pegar_emprestado(biblioteca[3])
usuario.pegar_emprestado(biblioteca[1])

bibliotecario.listar_livros(biblioteca)

usuario.devolver_livro(biblioteca[3])

bibliotecario.listar_livros(biblioteca)