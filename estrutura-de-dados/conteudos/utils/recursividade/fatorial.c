#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

unsigned long long fatorial(int num) {
	unsigned long long fat = 1;
	
	if(num <= 1) 
		return 1;
	else 
		return num * fatorial(num - 1);
}

int main(int argc, char *argv[]) {
	int num;
	setlocale(LC_ALL, "Portuguese");
	printf("\n\nEste programa calcula o fatorial de um número!");
	printf("\n\nInforme o número: ");
	scanf("%d", &num);
	
	printf("\n\nO fatorial de %d é: %d", num, fatorial(num));
	
	printf("\n\nObrigado por utilizar nosso programa!\n\n");
	return 0;
}
