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
	int num, i;
	setlocale(LC_ALL, "Portuguese");
	printf("\n\nEste programa imprime a série de fibonacci até um termo n!");
	printf("\n\nInforme a quantidade de termos: ");
	scanf("%d", &num);
	
	printf("\n\nSérie de Fibonacci: ");
	for(i = 1; i <= num; i++) {
		printf("%d, ", fibonacci(i));
	}
	printf("...");
	
	printf("\n\nObrigado por utilizar nosso programa!\n\n");
	system("pause");
	return 0;
}
