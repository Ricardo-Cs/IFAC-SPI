#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main(void) {
	system("cls");
	setlocale(LC_ALL, "Portuguese");
	float x, y, *p1, *p2, temp;
	printf("\n\nEste programa faz as quatro opera��es b�sicas entre dois valores utilizando ponteiros!");
	
	printf("\n\nInforme o primeiro valor: ");
	scanf("%f", &x);
	p1 = &x;
	
	printf("\n\nInforme o segundo valor: ");
	scanf("%f", &y);
	p2 = &y;
	
	system("cls");
	printf("\n\tRelat�rio inicial das vari�veis!");
	printf("\n\nEndere�o da vari�vel x: %p.", p1);
	printf("\n\nConte�do atribu�do em x: %.2f", *p1);
	
	printf("\n\nEndere�o da vari�vel y: %p.", p2);
	printf("\n\nConte�do atribu�do em y: %.2f", *p2);

	printf("\n\n\n\tOpera��es matem�ticas utilizando ponteiros!");
	printf("\n\nAdi��o: %.2f", *p1 + *p2);
	printf("\n\nSubtra��o: %.2f", *p1 - *p2);
	printf("\n\nMultiplica��o: %.2f", *p1 * *p2);
	printf("\n\nDivis�o: %.2f", *p1 / *p2);
	
	printf("\n\nObrigado por utilizar nosso programa!\n\n");
	return 0;
}
