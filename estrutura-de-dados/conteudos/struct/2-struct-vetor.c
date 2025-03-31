#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

struct info_pessoa {
	char nome_pessoa[80];
	int idade_pessoa;
	float peso_pessoa;
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
	int num, i;
	printf("\n\nEste programa manipula o cadastro de uma turma!");
	
	printf("\n\nInforme a quantidade de alunos: ");
	fflush(stdin);
	scanf("%d", &num);
	struct info_pessoa alunos[num];
	
	clear();
	
	for(i = 0; i < num; i++) {
		printf("\n\nInforme o nome do %d° aluno: ", i + 1);
		fflush(stdin);
		fgets(alunos[i].nome_pessoa, 79, stdin);
		
		printf("\n\nInforme a idade do %d° aluno: ", i + 1);
		fflush(stdin);
		scanf("%d", &alunos[i].idade_pessoa);
		
		printf("\n\nInforme o peso do %d aluno(kg): ", i + 1);
		fflush(stdin);
		scanf("%f", &alunos[i].peso_pessoa);	
		clear();
	}
	
	printf("\n\n\tLista da turma ");
	for(i = 0; i < num; i++) {
		printf("\n\n\nNome do %d° aluno: %s", i + 1, alunos[i].nome_pessoa);
		printf("\nIdade do %d° daluno: %d", i + 1, alunos[i].idade_pessoa);
		printf("\n\nPeso do %d° aluno: %.2f kg", i + 1, alunos[i].peso_pessoa);
	}
	
	printf("\n\n\nObrigado por utilizar nosso programa!\n\n\n");
	system("pause");
	return 0;
}
