#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main(void) {
	system("cls");
	setlocale(LC_ALL, "Portuguese");
	int num, *ptr;
	printf("\n\nEste programa verifica se existe espa�o dispon�vel em mem�ria para uma vari�vel do tipo inteiro!");
	
	ptr = (int*) malloc(sizeof(int));
	// Aloca espa�o em mem�ria para um n�mero inteiro e passa o endere�o do espa�o alocado para ptr.
	
	if(ptr == NULL) {
		printf("\n\nMem�ria insuficiente!");
		exit(1);
	}
	
	num = 100;
	ptr = &num;
	
	printf("\n\nConte�do: %d. \n\nEndere�o: %p.", *ptr, ptr);
	
	free(ptr); // Liberar o espa�o que outrora fora alocado
	
	// N�o � poss�vel fazer a impress�o abaixo, j� que o espa�o alocado para ptr foi liberado
	// printf("\n\nConte�do: %d. \n\nEndere�o: %p.", *ptr, ptr);
	printf("\n\nObrigado por utilizar nosso programa!\n\n");
	return 0;
}
