#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main(void) {
	system("cls");
	setlocale(LC_ALL, "Portuguese");
	int num, *ptr;
	printf("\n\nEste programa verifica se existe espaço disponível em memória para uma variável do tipo inteiro!");
	
	ptr = (int*) malloc(sizeof(int));
	// Aloca espaço em memória para um número inteiro e passa o endereço do espaço alocado para ptr.
	
	if(ptr == NULL) {
		printf("\n\nMemória insuficiente!");
		exit(1);
	}
	
	num = 100;
	ptr = &num;
	
	printf("\n\nConteúdo: %d. \n\nEndereço: %p.", *ptr, ptr);
	
	free(ptr); // Liberar o espaço que outrora fora alocado
	
	// Não é possível fazer a impressão abaixo, já que o espaço alocado para ptr foi liberado
	// printf("\n\nConteúdo: %d. \n\nEndereço: %p.", *ptr, ptr);
	printf("\n\nObrigado por utilizar nosso programa!\n\n");
	return 0;
}
