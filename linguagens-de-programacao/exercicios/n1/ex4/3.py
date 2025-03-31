lista = []
for i in range(1, 6):
    lista.append(input(f"Informe o {i}° nome: "))

lista.sort()

print("\nOrdem alfabética:", lista)