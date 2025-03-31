#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int fibonacci(int num) {
	
	if(num <= 2) 
		return 1;
	else 
		return fibonacci(num - 1) + fibonacci(num - 2);
}

int main(int argc, char *argv[]) {
	int num;
	setlocale(LC_ALL, "Portuguese");
	printf("\n\nEste programa imprime um valor da sequ�ncia de fibonacci com base na sua posi��o!");
	printf("\n\nInforme a posi��o do n�mero: ");
	scanf("%d", &num);
	
	printf("\n\nValor: %d", fibonacci(num));
	
	printf("\n\nObrigado por utilizar nosso programa!\n\n");
	return 0;
}
