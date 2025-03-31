lista = []
for i in range(1, 6):
    lista.append(int(input(f'Informe o {i}° valor: ')))

print("\nMaior:", max(lista))
print("Menor:", min(lista))
print("Soma:", sum(lista))