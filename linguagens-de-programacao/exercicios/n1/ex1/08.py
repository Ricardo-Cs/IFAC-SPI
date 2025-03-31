produto = float(input('Informe o valor do produto: '))
valor = float(input('Informe o valor que foi pago: '))

if(produto - valor == 0):
    print('\nSem troco a ser devolvido!')
elif(produto - valor > 0):
    print('\nO valor pago não é o suficiente!')
else:
    print('\nO troco a ser devolvido é:', valor - produto)