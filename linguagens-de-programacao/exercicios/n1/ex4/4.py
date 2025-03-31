lista = []
for i in range(1, 6):
    lista.append(input(f'Informe o {i}° valor: '))

print("\nLista: ", lista)
removeNum = input("\nInforme um número para remover: ")

if removeNum in lista:
    lista.remove(removeNum)
    print("\nNova lista:", lista)
else:
    print("\nO número não existe na lista!")
