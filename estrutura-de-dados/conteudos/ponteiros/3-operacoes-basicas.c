#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main(void) {
	system("cls");
	setlocale(LC_ALL, "Portuguese");
	float x, y, *p1, *p2, temp;
	printf("\n\nEste programa faz as quatro operações básicas entre dois valores utilizando ponteiros!");
	
	printf("\n\nInforme o primeiro valor: ");
	scanf("%f", &x);
	p1 = &x;
	
	printf("\n\nInforme o segundo valor: ");
	scanf("%f", &y);
	p2 = &y;
	
	system("cls");
	printf("\n\tRelatório inicial das variáveis!");
	printf("\n\nEndereço da variável x: %p.", p1);
	printf("\n\nConteúdo atribuído em x: %.2f", *p1);
	
	printf("\n\nEndereço da variável y: %p.", p2);
	printf("\n\nConteúdo atribuído em y: %.2f", *p2);

	printf("\n\n\n\tOperações matemáticas utilizando ponteiros!");
	printf("\n\nAdição: %.2f", *p1 + *p2);
	printf("\n\nSubtração: %.2f", *p1 - *p2);
	printf("\n\nMultiplicação: %.2f", *p1 * *p2);
	printf("\n\nDivisão: %.2f", *p1 / *p2);
	
	printf("\n\nObrigado por utilizar nosso programa!\n\n");
	return 0;
}
