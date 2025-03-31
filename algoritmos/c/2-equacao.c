#include <stdio.h>
#include <math.h>
#include <locale.h>
#include <stdlib.h>

int main() {
	setlocale(LC_ALL, "Portuguese");
	printf("Esse programa determina a quantidade de ra�zes de uma equa��o do segundo grau e o valor de delta!\n");
	float a, b, c, delta;
	printf("Informe o valor do coeficiente 'a': ");
	scanf("%f", &a);
	
	if(a == 0) {
		system("cls");
		printf("O coeficiente 'a' n�o pode ser zero!");
	} else {
		printf("Informe o valor do coeficiente 'b': ");
		scanf("%f", &b);
		printf("Informe o valor do coeficiente 'c': ");
		scanf("%f", &c);
		
		system("cls");
		delta = pow(b, 2.0) - 4.0 * a * c;
		
		if(delta < 0) {
			printf("A equa��o n�o possui ra�zes reais, delta = %.2f", delta);
		}
		
		if(delta == 0) {
			printf("A equa��o possui uma ra�z real, delta = %.2f", delta);
		}
		
		if(delta > 0) {
			printf("A equa��o possui duas ra�zes reais, delta = %.2f", delta);
		}
	}
	
	return 0;
}
