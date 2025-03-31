import os

def mostrarMenu():
    print("\n\tLISTA TELEFÔNICA\n")
    print("1 - Adicionar registro")
    print("2 - Listar registros")
    print("3 - Buscar registro")
    print("4 - Remover registro")
    print("5 - Sair")

def adicionarRegistro():
    nome = input("Informe o nome para adicionar: ")
    num = input("Informe o número de telefone para adicionar: ")
    lista.update({nome: num})

def listarRegistros():
    for i, (nome, telefone) in enumerate(lista.items(), start=1):
        print(f"{i} - {nome}: {telefone}")

def buscarRegistro():
    busca = input("Informe o nome ou número que deseja buscar: ")

    print("\nRegistros encontrados: ")
    for nome, telefone in lista.items():
        if busca == nome or busca == telefone:
             print(f"{nome}: {telefone}")

def removerRegistro():
    listarRegistros()
    indice = int(input("\nInforme o índice do registro que deseja remover: "))

    if indice < 1 or indice > len(lista):
        print("Valor inválido! Tente novamente")
    else:
        chave_para_remover = list(lista.keys())[indice - 1]
        lista.pop(chave_para_remover)

lista = {}
while(True):
    mostrarMenu()
    op = input("\nInforme a ação que deseja realizar: ")
    os.system("cls")

    if op == "1":
        adicionarRegistro()
    elif op == "2":
        listarRegistros()
    elif op == "3":
        buscarRegistro()
    elif op == "4":
        removerRegistro()
    elif op == "5":
        break
    else:
        print("Valor inválido")
    
    input("\nPressione qualquer tecla para continuar...")
    os.system("cls")

print("Obrigado por utilizar o nosso programa!")