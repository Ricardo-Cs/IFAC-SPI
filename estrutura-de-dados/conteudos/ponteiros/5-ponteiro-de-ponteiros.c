#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main(void) {
	system("cls");
	setlocale(LC_ALL, "Portuguese");
	int tam, i;
	printf("\n\nEste programa carrega e imprime um vetor vet qualquer!");
	printf("\n\nInforme a quantidade de elementos do vetor vet: ");
	scanf("%d", &tam);
	
	// Criando um vetor de ponteiros para manipulação de números inteiros
	int **vet = (int **) malloc(tam * sizeof(int *));
	// Se existir espaço em memória, foi realizada alocação de memória e criação de vet
	
	if(vet == NULL) {
		printf("\n\nErro no processo de alocação de memória!");
		return 1;
	}
	
	printf("\n\nInforme os elementos do vetor vet!");
	for(i = 0; i < tam; i++) {
		vet[i] = (int *) malloc(sizeof(int)); // Alocação por unidade
		// Alocando e criando cada "espaço" vet[i]
		
		if(vet[i] == NULL) {
			printf("\n\nErro no processo de alocação de memória para o elemento de index %d", i);
			return 1;
		}
		
		printf("\n\nInforme o valor para o elemento vet[%d]: ", i);
		scanf("%d", vet[i]);
	}
	
	system("cls");
	
	printf("\n\nVetor vet = [");
	for(i = 0; i < tam; i++) {
		printf(" %d ", *vet[i]);
	}
	printf("]");
	
	// Liberando espaço de memória de cada elemento
	for(i = 0; i < tam; i++) {
		free(vet[i]);
	}
	
	// Liberando espaço de memória global do vetor
	free(vet);

	printf("\n\nObrigado por utilizar nosso programa!\n\n");
	return 0;
}
