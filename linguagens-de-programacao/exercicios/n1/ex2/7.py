import random
import os

numRandom = random.randint(1, 10)
num = int(input("\nInsira um número entre 1 e 10: "))
os.system("cls")

if(numRandom == num): 
    print("\nVocê acertou!!!")
else: 
    print("\nVocê errou... o número era", numRandom)