#include <stdio.h>
#include <stdlib.h>
#include <locale.h>
#include <string.h>
#include <ctype.h>

int main() {
	setlocale(LC_ALL, "Portuguese"); 
	char palavra[100], reversa[100];
	printf("Esse programa verifica se uma palavra � um pal�ndromo!\n");
	printf("Informe a palavra para verificar: ");
	scanf("%s", &palavra);
	int tam = strlen(palavra), i;
	
	for(i = 0; i <= tam; i++) {
		palavra[(tam - 1) - i] = tolower(palavra[(tam - 1) - i]);
		reversa[i] = palavra[(tam - 1) - i];
	}
	
	if(strcmp(palavra, reversa) == 0) printf("A palavra � um pal�ndromo!");
	else printf("A palavra n�o � um pal�ndromo!");
	
	return 0;
}
