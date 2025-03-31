#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main(void) {
	system("cls");
	setlocale(LC_ALL, "Portuguese");
	int linhas, colunas, i, j;
	printf("\n\nEste programa carrega e imprime uma matriz A qualquer!");
	
	printf("\n\nInforme a quantidade de linhas de A: ");
	scanf("%d", &linhas);
	printf("\n\nInforme a quantidade de colunas de A: ");
	scanf("%d", &colunas);
	
	int **A = (int **) malloc(linhas * sizeof(int *));

	if(A == NULL) {
		printf("\n\nErro no processo de alocação de memória!");
		return 1;
	}
	
	for(i = 0; i < linhas; i++)
		A[i] = malloc(colunas * sizeof(int *));
	
	printf("\n\nInforme os elementos da matriz A!");
	for(i = 0; i < linhas; i++) {
		A[i] = (int *) malloc(sizeof(int));
		
		if(A[i] == NULL) {
			printf("\n\nErro no processo de alocação de memória para o elemento de index %d %d", i, j);
			return 1;
		}
		
		for(j = 0; j < colunas; j++) {
			printf("\n\nInforme o valor para o elemento A[%d][%d]: ", i, j);
			scanf("%d", *(A + i) + j);
		}
	}
	
	system("cls");
	
	printf("\n\nMatriz A =");
	for(i = 0; i < linhas; i++) {
		printf("\n");
		for(j = 0; j < colunas; j++) {
			printf(" %d ", *(*(A + i) + j));
		}
	}
	
	for(i = 0; i < linhas; i++) {
		free(A[i]);
	}
	
	free(A);
	
	printf("\n\nObrigado por utilizar nosso programa!\n\n");
	return 0;
}
