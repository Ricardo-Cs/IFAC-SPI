frase = input("Insira uma frase para análise: ").lower()
busca = input("Insira uma palavra para busca: ")

print(f"\nQuantidade de caracteres da frase: {len(frase)}")
print(f"Quantidade de palavras da frase: {len(frase.split())}")
print(f"Quantidade de vezes que a palavra '{busca}' aparece: {frase.count(busca)}")