class Animal:
    def __init__(self, nome):
        self.nome = nome
    
    def fazer_som(self):
        print('Som genérico do animal.')

class Cachorro(Animal):
    def fazer_som(self):
        print('Au Au!')

class Gato(Animal):
    def fazer_som(self):
        print('Miau!')

animal = Animal('Animal')
cachorro = Cachorro('Cachorro')
gato = Gato('Gato')

animal.fazer_som()
cachorro.fazer_som()
gato.fazer_som()