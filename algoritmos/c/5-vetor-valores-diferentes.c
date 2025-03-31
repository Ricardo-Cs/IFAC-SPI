#include <stdio.h>
#include <locale.h>
#include <stdbool.h>

int main() {
	setlocale(LC_ALL, "Portuguese");
	int vetor[10], contador = 0, i;
	printf("Esse programa insere 10 números diferentes em um vetor!\n");
	
	while(contador != 10) {
		int valor;
		bool igual = false;
		printf("Informe o %d° valor: ", contador + 1);
		scanf("%d", &valor);
		
		for(i = 0; i <= contador; i++) {
			if(vetor[i] != valor) igual = false;
			else {
				igual = true;
				break;
			}
		}
		
		if(igual == false) {
			vetor[contador] = valor;
			contador++;
		} else {
			printf("O valor já existe no vetor!\n");
		}
	}
	
	printf("Vetor: [ ");
	for(i = 0; i < 10; i++) {
		printf("%d ", vetor[i]);
	}
	printf("]");
	
	return 0;
}
