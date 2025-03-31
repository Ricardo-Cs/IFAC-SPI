#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void clear() {
	printf("\n\n\n");
	system("pause");
	system("cls");
}

int main(void) {
	system("cls");
	// Caso a entrada tenha caracteres especiais, dará erro por conta dessa linha
	setlocale(LC_ALL, "Portuguese");
	
	// Melhor criar globalmente.
	struct info_pessoa {
		char nome_pessoa[80];
		int idade_pessoa;
		float peso_pessoa;
	};
	
	struct info_pessoa aluno;
	
	printf("\n\nEste programa manipula o cadastro de um aluno!");
	printf("\n\nInforme o nome do aluno: ");
	fflush(stdin); // Limpa o buffer de entrada, impede que algum lixo de memória seja concatenado na entrada.
	fgets(aluno.nome_pessoa, 79, stdin);
	
	printf("\n\nInforme a idade do aluno: ");
	fflush(stdin);
	scanf("%d", &aluno.idade_pessoa);
	
	printf("\n\nInforme o peso do aluno(kg): ");
	fflush(stdin);
	scanf("%f", &aluno.peso_pessoa);
	
	clear();
	
	printf("\n\n\tRelatório Acadêmico");
	printf("\n\nNome do aluno: %s", aluno.nome_pessoa);
	printf("\n\nIdade do aluno: %d", aluno.idade_pessoa);
	printf("\n\nPeso do aluno: %.2f kg", aluno.peso_pessoa);
	
	printf("\n\nObrigado por utilizar nosso programa!\n\n");
	system("pause");
	return 0;
}
