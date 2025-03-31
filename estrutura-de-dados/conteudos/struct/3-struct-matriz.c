#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

struct info_pessoa {
	char nome_pessoa[80];
	int idade_pessoa;
	float peso_pessoa;
	int tipo;
};

void clear() {
	printf("\n\n\n");
	system("pause");
	system("cls");
}

int main(void) {
	system("cls");
	// Caso a entrada tenha caracteres especiais, dará erro por conta dessa linha
	setlocale(LC_ALL, "Portuguese");
	int num, i, j;
	printf("\n\nEste programa manipula o cadastro de alunos, docentes e técnicos administrativos!");
	
	printf("\n\nInforme a quantidade de pessoas em cada classificação: ");
	fflush(stdin);
	scanf("%d", &num);
	struct info_pessoa pessoas[3][num];
	
	clear();
	
	for(i = 0; i < 3; i++) {		
		for(j = 0; j < num; j++) {
			if(i == 0) {
				printf("\n\nInforme os dados dos alunos");
				pessoas[i][j].tipo = 1;
			} else if(i == 1) {
				printf("\n\nInforme os dados dos docentes");
				pessoas[i][j].tipo = 2;
			} else {
				printf("\n\nInforme os dados dos administrativos");
				pessoas[i][j].tipo = 3;
			}
			
			printf("\n\nInforme o nome da pessoa %d: ", i + 1);
			fflush(stdin);
			fgets(pessoas[i][j].nome_pessoa, 79, stdin);
			
			printf("\n\nInforme a idade da pessoa %d: ", i + 1);
			fflush(stdin);
			scanf("%d", &pessoas[i][j].idade_pessoa);
			
			printf("\n\nInforme o peso do aluno %d (kg): ", i + 1);
			fflush(stdin);
			scanf("%f", &pessoas[i][j].peso_pessoa);
			
			clear();
		}
	}
	
	printf("\n\n\tLista");
	for(i = 0; i < 3; i++) {
		for(j = 0; j < num; j++) {
			printf("\n\n\nNome da pessoa %d: %s", i + 1, pessoas[i][j].nome_pessoa);
			printf("\nIdade da pessoa %d: %d", i + 1, pessoas[i][j].idade_pessoa);
			printf("\n\nPeso da pessoa %d: %.2f kg", i + 1, pessoas[i][j].peso_pessoa);
			
			if(i == 0) printf("\n\nTipo da pessoa: Aluno");
			else if(i == 0) printf("\n\nTipo da pessoa: Docente");
			else printf("\n\nTipo da pessoa: Administrativo");
		}
	}
	
	printf("\n\n\nObrigado por utilizar nosso programa!\n\n\n");
	system("pause");
	return 0;
}
