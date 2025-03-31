notas = 0.0
for i in range(1, 4):
    num = float(input(f'Informe a {i}° nota: '))
    notas += num

print('A média do aluno é:', round(notas / 3, 1))