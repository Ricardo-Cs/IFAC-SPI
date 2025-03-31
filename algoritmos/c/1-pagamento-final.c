#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main() {
	setlocale(LC_ALL, "Portuguese");
	printf("Esse programa calcula o pagamento final de uma compra e o valor de cada parcela!\n");
	printf("Informe o valor da compra: ");
	float compra;
	int op, parcela;
	scanf("%f", &compra);
	
	printf("Opções de pagamento: \n");
	printf("(1)A vista\n(2)Parcelado");
	printf("\nInforme a forma de pagamento: ");
	scanf("%d", &op);
	system("cls");
	
	switch(op) {
		case 1: 
			printf("O valor final da sua compra foi: %.2f", compra - (compra * 0.05));
			break;
		case 2: 
			printf("Informe a quantidade de parcelas (entre 2 e 10): ");
			scanf("%d", &parcela);
			
			if(parcela > 1 && parcela < 4) {
				printf("O valor final da sua compra foi: %.2f\n", compra);
				printf("O valor de cada parcela será %.2f", compra / parcela);	
			} else if(parcela > 3 && parcela < 6) {
				printf("O valor final da sua compra foi: %.2f\n", compra + (compra * 0.02));
				printf("O valor de cada parcela será %.2f", (compra + (compra * 0.02)) / parcela);	
			} else if(parcela > 5 && parcela < 11) {
				printf("O valor final da sua compra foi: %.2f", compra + (compra * 0.08));
				printf("O valor de cada parcela será %.2f", compra + (compra * 0.08) / parcela);	
			} else {
				printf("Valor inválido!");
			}	
			break;
		default: 
			printf("Valor inválido!");
	}
	
	
	return 0;
}
