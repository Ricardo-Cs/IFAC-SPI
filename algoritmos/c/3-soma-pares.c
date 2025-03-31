#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main() {
	setlocale(LC_ALL, "Portuguese"); 
	int qtd;
	printf("Esse programa calcula o somat�rio de uma sequ�ncia de pares de n�meros!\n");
	
	printf("Informe a quantidade de pares de n�meros: ");
	scanf("%d", &qtd);
	system("cls");
	
	while(qtd) {
		int n1, n2, sum = 0, x, y, i;
		printf("Informe o par de n�meros: \n");
		scanf("%d %d", &n1, &n2);
		
		if(n1 == n2) {
			printf("Os n�meros s�o iguais! Tente novamente.\n\n");
		} else {
			if(n1 > n2) {
				x = n2;
				y = n1;
			} else {
				x = n1;
				y = n2;
			}
			
			for(i = x; i <= y; i++) {
				sum += i;
			}
			
			printf("A soma dos valores entre %d e %d � igual a: %d\n\n", x, y, sum);
			qtd--;
		}
	}
	return 0;
}
