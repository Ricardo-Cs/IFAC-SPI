#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main() {
	setlocale(LC_ALL, "Portuguese"); 
	int qtd;
	printf("Esse programa calcula o somatório de uma sequência de pares de números!\n");
	
	printf("Informe a quantidade de pares de números: ");
	scanf("%d", &qtd);
	system("cls");
	
	while(qtd) {
		int n1, n2, sum = 0, x, y, i;
		printf("Informe o par de números: \n");
		scanf("%d %d", &n1, &n2);
		
		if(n1 == n2) {
			printf("Os números são iguais! Tente novamente.\n\n");
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
			
			printf("A soma dos valores entre %d e %d é igual a: %d\n\n", x, y, sum);
			qtd--;
		}
	}
	return 0;
}
