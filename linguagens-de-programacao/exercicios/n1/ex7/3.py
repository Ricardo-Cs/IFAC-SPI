frase = input("Insira uma frase: ")
busca = input("Insira a palavra que deseja substituir: ")
valor = input("Insira a palavra que deseja inserir: ")

if frase.find(busca) != -1:
    novaFrase = frase.replace(busca, valor)
    print(f"\nNova frase: {novaFrase}")
else:
    print("\nA palavra não existe!")