# Tipos de variáveis
def types(value):
    print(type(value))

types(10)
types(10.0)
types(range(5))
types('Texto')
types(True)
types(('Ouro', 'Prata', 'Bronze'))
types(['Ouro', 'Prata', 'Bronze'])
types({'Ouro', 'Prata', 'Bronze'})
types(frozenset({"apple", "banana", "cherry"}))
types(b"Hello")
types({'nome': 'Ricardo', 'idade': 19})

# Operadores matemáticos
x = 5
y = 5

print("\n\nSoma:", x + y)
print("Subtração:", x - y)
print("Multiplicação:", x * y)
print("Divisão:", x / y)
print("Divisão de inteiros:", x // y)
print("Potência:", x ** y)
print("Resto:", x % y)
