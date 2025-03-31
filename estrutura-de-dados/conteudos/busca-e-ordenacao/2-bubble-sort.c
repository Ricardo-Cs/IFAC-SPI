#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void clear() {
	printf("\n\n\n");
	system("pause");
	system("cls");
}

int main(void) {
	system("cls");	
	setlocale(LC_ALL, "Portuguese");
	int tam, i, num, control = 0, lsup, aux, bubble;
	printf("\n\nEste programa ordena um vetor A qualquer, utilizando o método bubble!");
	printf("\n\nInforme o tamanho do vetor A: ");
	scanf("%d", &tam);
	int A[tam];	
	clear();
	printf("\n\nInforme os elementos do vetor A!");
	for(i = 0; i < tam; i++) {
		printf("\n\nInforme o elemento A[%d]: ", i);
		scanf("%d", &A[i]);
	}
	clear();
	printf("\n\nVetor Original A: [");
	for(i = 0; i < tam; i++) {
		printf(" %d ", A[i]);
	}
	printf("]");
	
	//Ordenação crescente
	lsup = tam - 1;
	while(lsup > 0) {
		bubble = 0;
		for(i = 0; i < lsup; i++) {
			if(A[i] > A[i + 1]) {
				aux = A[i];
				A[i] = A[i + 1];
				A[i + 1] = aux;
				bubble = i; 
			}
		}
		lsup = bubble;
	}
	
	printf("\n\nVetor A em ordem crescente: [");
	for(i = 0; i < tam; i++) {
		printf(" %d ", A[i]);
	}
	printf("]");
	
	//Ordenação decrescente
	lsup = tam - 1;
	while(lsup > 0) {
		bubble = 0;
		for(i = 0; i < lsup; i++) {
			if(A[i] < A[i + 1]) {
				aux = A[i];
				A[i] = A[i + 1];
				A[i + 1] = aux;
				bubble = i; 
			}
		}
		lsup = bubble;
	}
	
	printf("\n\nVetor A em ordem decrescente: [");
	for(i = 0; i < tam; i++) {
		printf(" %d ", A[i]);
	}
	printf("]");
	
	printf("\n\nObrigado por utilizar nosso programa!");
	system("pause");
	return 0;
}
