#include <stdio.h>
#include <locale.h>
#include <stdlib.h>

float soma_vetor(int posicao, float vetor[]) {
    if (posicao == 0) 
        return 0.0;
    else 
        return vetor[posicao - 1] + soma_vetor(posicao - 1, vetor);	
}

int main() {
    setlocale(LC_ALL, "Portuguese");
    float vetor[10], soma = 0.0;
    int i;
    printf("Esse programa calcula a soma de um vetor de tamanho 10 com recursividade!\n");
    
    for(i = 0; i < 10; i++) {
        printf("Informe o valor na %d° posição: ", i + 1);
        scanf("%f", &vetor[i]);
        system("cls");
    }
    
    soma = soma_vetor(10, vetor);
    printf("Soma: %.2f\n", soma);
}

