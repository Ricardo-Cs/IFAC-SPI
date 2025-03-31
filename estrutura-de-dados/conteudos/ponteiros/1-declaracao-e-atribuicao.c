#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main(void) {
	system("cls");
	setlocale(LC_ALL, "Portuguese");
	int x, y, z;
	int *ptr; // Ponteiro
	
	x = 10, y = 20, z = 30;
	ptr = &x;
	
	printf("\n\nEndereço de x: %p.", ptr); // Acessar endereço = ptr
	printf("\n\nConteúdo de x com base em ptr: %d.", *ptr); // Acessar valor no endereço = *ptr
	
	printf("\n\nObrigado por utilizar nosso programa!\n\n");
	return 0;
}
