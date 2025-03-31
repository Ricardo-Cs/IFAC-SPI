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
	int m, n, i, j, k, num, control = 0, lsup, aux, bubble;
	printf("\n\nEste programa ordena uma matriz A de valores aleatórios!");
	printf("\n\nInforme a quantidade de linhas de A: ");
	scanf("%d", &m);	
	printf("\n\nInforme a quantidade de colunas de A: ");
	scanf("%d", &n);
	int A[m][n], vetor[m * n];
	
	for(i = 0; i < m; i++) {
		for(j = 0; j < n; j++) {
			//Obter números aleatórios
			 int num = rand() % 9;
			 A[i][j] = num;
		}
	}
	clear();
	
	printf("\n\nMatriz A Original: \n");
	for(i = 0; i < m; i++) {
		printf("\n");
		for(j = 0; j < n; j++) {
			printf(" %d ", A[i][j]);
		}	
	}
	
	//Transforma matriz em um vetor
	k = 0;
	for(i = 0; i < m; i++) {
		for(j = 0; j < n; j++) {
			vetor[k++] = A[i][j];
		}
	}
	
	//Ordena vetor
	lsup = (m * n) - 1;
	while(lsup > 0) {
		bubble = 0;
		for(i = 0; i < lsup; i++) {
			if(vetor[i] > vetor[i + 1]) { // Para ordenar em ordem descrecente -> vetor[i] < vetor[i + 1]
				aux = vetor[i];
				vetor[i] = vetor[i + 1];
				vetor[i + 1] = aux;
				bubble = i; 
			}	
		}
		lsup = bubble;
	}
	
	// Transforma o vetor em matriz novamente
	k = 0;
	for(i = 0; i < m; i++) {
		for(j = 0; j < n; j++) {
			A[i][j] = vetor[k++];
		}
	}
	
	printf("\n\nMatriz A em ordem crescente: \n");
	for(i = 0; i < m; i++) {
		printf("\n");
		for(j = 0; j < n; j++) {
			printf(" %d ", A[i][j]);
		}	
	}
	
	printf("\n\nObrigado por utilizar nosso programa!\n\n");
	system("pause");
	return 0;
}
