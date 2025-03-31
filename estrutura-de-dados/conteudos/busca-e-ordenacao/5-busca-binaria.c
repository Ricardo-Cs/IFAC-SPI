#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void clear() {
	printf("\n\n\n");
	system("pause");
	system("cls");
}

int buscaBinaria(int n, int numBusca, int A[]) {
	int esq = -1, dir = n;
	
	while(esq < dir - 1) {
		int meio = (esq + dir) / 2;
		if(A[meio] < numBusca) esq = meio;
		else dir = meio;
	}
	return dir;
}

int main(void) {
	system("cls");	
	setlocale(LC_ALL, "Portuguese");
	int tam, i, numBusca;
	printf("\n\nEste programa realiza uma busca binária em um vetor A ordenado!");
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
	printf("\n\nVetor A: [");
	for(i = 0; i < tam; i++)
		printf(" %d ", A[i]);
	printf("]");
	
	printf("\n\n\nInforme um valor para busca no vetor A: ");
	scanf("%d", &numBusca);
	
	if(numBusca < A[0] || numBusca > A[tam - 1])
		printf("\n\nO número %d não faz parte do vetor A!", numBusca);
	else
		printf("\n\nO número %d foi localizado na posição: %d!", numBusca, buscaBinaria(tam, numBusca, A));
	
	printf("\n\nObrigado por utilizar nosso programa!");
	system("pause");
	return 0;
}
