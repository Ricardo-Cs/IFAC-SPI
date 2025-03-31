palavra = input("Insira uma palavra para verificar: ").lower()

if palavra == palavra[::-1]:
    print("\nA palavra é um palíndromo!")
else:
    print("\nA palavra não é um palíndromo!")