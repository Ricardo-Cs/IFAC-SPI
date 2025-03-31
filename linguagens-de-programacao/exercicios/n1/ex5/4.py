import os

def soma(num1, num2):
    print("Soma:", num1 + num2)

def sub(num1, num2):
    print("Subtração:", num1 - num2)

def mult(num1, num2):
    print("Multiplicação:", num1 * num2)

def div(num1, num2):
    if num1 == 0 or num2 == 0:
        print("Um dos valores é 0! Não é possível fazer a divisão")
    else:
        print("Divisão:", num1 / num2)

while True:
    print("\n\tCALCULADORA")
    print("1 - Soma")
    print("2 - Subtração")
    print("3 - Multiplicação")
    print("4 - Divisão")
    print("5 - Sair")

    op = input("Informe a operação desejada: ")
    num1 = int(input("Informe o primeiro valor: "))
    num2 = int(input("Informe o segundo valor: "))

    os.system("cls")

    if op == "1":
        soma(num1, num2)
    elif op == "2":
        sub(num1, num2)
    elif op == "3":
        mult(num1, num2)
    elif op == "4":
        div(num1, num2)
    elif op == "5":
        break
    else:
        print("Valor inválido!")
    
    input("Digite qualquer tecla para continuar...")
    os.system("cls")