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
	int tam, i, num, control = 0;
	printf("\n\nEste programa busca um elemento em um vetor A qualquer!");
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
	for(i = 0; i < tam; i++) {
		printf(" %d ", A[i]);
	}
	printf("]");
	
	printf("\n\n\nInforme um valor para busca no vetor A: ");
	scanf("%d", &num);
	
	//Busca sequencial - Ineficiente
	for(i = 0; i < tam; i++) {
		if(num == A[i]) {
			control = 1;
			printf("\n\nO número %d foi localizado em A na posição %d!", num, i);
		}
	}
	
	if(control == 0) printf("\n\nO número %d não foi localizado no vetor A!");
	
	printf("\n\nObrigado por utilizar nosso programa!");
	system("pause");
	return 0;
}
