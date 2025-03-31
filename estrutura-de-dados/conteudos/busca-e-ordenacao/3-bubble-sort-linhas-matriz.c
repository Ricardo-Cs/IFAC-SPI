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
	int m, n, i, j, num, control = 0, lsup, aux, bubble;
	printf("\n\nEste programa ordena as linhas de uma matriz A qualquer!");
	printf("\n\nInforme a quantidade de linhas de A: ");
	scanf("%d", &m);	
	printf("\n\nInforme a quantidade de colunas de A: ");
	scanf("%d", &n);
	int A[m][n];
	clear();
	printf("\n\nInforme os elementos da matriz A!");
	for(i = 0; i < m; i++) {
		for(j = 0; j < n; j++) {
//			printf("\n\nInforme o elemento A[%d][%d]: ", i, j);
//			scanf("%d", &A[i][j]);
			
			//Obter números aleatórios, caso preciso
			 int num = rand() % 10;
			 A[i][j] = num;
		}
	}

	clear();
	printf("\n\nMatriz Original A: \n");
	for(i = 0; i < m; i++) {
		printf("\n");
		for(j = 0; j < n; j++) {
			printf(" %d ", A[i][j]);
		}	
	}
	
	//Ordenação crescente
	lsup = n - 1;
	while(lsup > 0) {
		bubble = 0;
		for(i = 0; i < m; i++) {
			for(j = 0; j < lsup; j++) {
				if(A[i][j] > A[i][j + 1]) {
					aux = A[i][j];
					A[i][j] = A[i][j + 1];
					A[i][j + 1] = aux;
					bubble = j; 
				}	
			}
		}
		lsup = bubble;
	}
	
	printf("\n\nMatriz A em ordem crescente: \n");
	for(i = 0; i < m; i++) {
		printf("\n");
		for(j = 0; j < n; j++) {
			printf(" %d ", A[i][j]);
		}	
	}
	
	//Ordenação crescente
	lsup = n - 1;
	while(lsup > 0) {
		bubble = 0;
		for(i = 0; i < m; i++) {
			for(j = 0; j < lsup; j++) {
				if(A[i][j] < A[i][j + 1]) {
					aux = A[i][j];
					A[i][j] = A[i][j + 1];
					A[i][j + 1] = aux;
					bubble = j; 
				}	
			}
		}
		lsup = bubble;
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
