# Abre o arquivo. Pode ser r (ler), w (escrever, mas sobrescreve o arquivo), a (escrever, mas adiciona ao final do arquivo), x (criar)
# arquivo = open('linguagens.txt', 'a') - Se for aberto assim, será necessário fazer um close no final.
# with open('linguagens.txt', 'r') as arquivo: - Não precisa fechar o arquivo, fechará ao final da execução

# print(arquivo.readable()) - Verifica se o arquivo é possível de ler
# print(arquivo.read()) - Lê o arquivo inteiro
# print(arquivo.readline()) - Lê cada linha do arquivo, se for chamado outra vez irá ler a linha seguinte
# lista = arquivo.readlines() - Transforma cada linha do arquivo em um elemento da lista

# arquivo.write('\nSQL') - Escreve no arquivo, terá comportamento diferente dependendo de como o arquivo foi aberto ('w' ou 'a')

# Tratando exceção
try:
    with open('linguagens.txt', 'x') as arquivo:
        arquivo.write("\nAdicionando texto")
except FileExistsError: 
    print("Arquivo já existe")
