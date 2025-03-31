#include "mathlib.h"

// argc – é um valor inteiro que indica a quantidade de argumentos que foram passados ao chamar o programa.
// argv – é um vetor de char que contém os argumentos, um para cada string passada na linha de comando.
int main(int argc, char *argv[]) {
	system("cls");
	setlocale(LC_ALL, "Portuguese");
	float x, y;
	printf("\n\nEste programa calcula a soma e a multiplicação entre dois números reais!");
	clear();
	printf("\n\nInforme o primeiro número: ");
	scanf("%f", &x);
	printf("\n\nInforme o segundo número: ");
	scanf("%f", &y);
	
	printf("\n\n%.2f + %.2f = %.2f", x, y, addNum(x, y));
	printf("\n\n%.2f * %.2f = %.2f", x, y, multNum(x, y));
	printf("\n\nObrigado por utilizar nosso programa!\n\n");
	system("pause");
	return 0;
}
