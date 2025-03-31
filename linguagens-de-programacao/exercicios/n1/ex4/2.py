lista = []
for i in range(1, 11):
    lista.append(i)

num = int(input("Informe um número para a tabuada: "))

for i in range(1, 11):
    print(f"{num} x {i} = {num * i}")