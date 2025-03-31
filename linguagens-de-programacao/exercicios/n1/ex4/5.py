import os

def mostrarMenu():
    print("\n\tCARRINHO DE COMPRAS\n")
    print("1 - Adicionar produto")
    print("2 - Ver carrinho")
    print("3 - Remover produto")
    print("4 - Sair")

def listarProdutos():
    if len(carrinho) == 0:
        print("Carrinho vazio!")
    else:
        print("Lista dos produtos: \n")
        for i, produto in enumerate(carrinho, start=1):
            print(f"{i} - {produto}")

def removerProduto():
    listarProdutos()

    index = int(input("\nInforme o número do produto que deseja remover: "))

    if 1 <= index <= len(carrinho):
        carrinho.pop(index - 1)
        print("\nProduto removido com sucesso!")
    else: 
        print("\nProduto não existe! Tente novamente.")
        

carrinho = []

while True:
    mostrarMenu()
    op = input("\nInforme a ação que deseja fazer: ")
    os.system("cls")

    if op == "1":
        carrinho.append(input("Informe o produto para adicionar: "))
    elif op == "2":
        listarProdutos()
        input("\nPressione qualquer tecla para continuar...")
    elif op == "3":
        removerProduto()
        input("\nPressione qualquer tecla para continuar...")
    elif op == "4":
        break
    else:
        print("Valor inválido! Tente novamente.")
    
    os.system("cls")

print("Obrigado por utilizar nosso sistema!")