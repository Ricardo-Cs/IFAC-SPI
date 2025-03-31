#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

void clear() {
	printf("\n\n\n");
	system("pause");
	system("cls");
}

struct Pessoa {
	char nome[80];
	int idade;
	float peso;
};

struct Pop {
	struct Pessoa *pessoas;
	int quant_pessoas;
};

int main(void) {
	system("cls");
	setlocale(LC_ALL, "Portuguese");
	struct Pop pop;
	int i;
	
	printf("\n\nEste programa cadastra os dados de n pessoas de uma população qualquer!");
	printf("\n\nInforme a quantidade de pessoas que serão cadastradas: ");
	scanf("%d", &pop.quant_pessoas);
	
	pop.pessoas = (struct Pessoa *) malloc(pop.quant_pessoas * sizeof (struct Pessoa));
	
	if(pop.pessoas == NULL) {
		printf("\n\nErro no processo de alocação de memória!");
		return 1;
	}
	
	clear();
	
	for(i = 0; i < pop.quant_pessoas; i++) {
		printf("\n\n\tCadastro de pessoa n° %d", i + 1);
		printf("\n\nInforme o nome da pessoa: ");
		scanf(" %[^\n]", &pop.pessoas[i].nome);
		printf("\n\nInforme a idade da pessoa (anos completos): ");
		scanf("%d", &pop.pessoas[i].idade);
		printf("\n\nInforme o peso da pessoa (kg): ");
		scanf("%f", &pop.pessoas[i].peso);
		clear();
	}
	
	printf("\n\n\tBase de dados - Cadastro de pessoas");
	for(i = 0; i < pop.quant_pessoas; i++) {
		printf("\n\n\nPessoa n° %d", i + 1);
		printf("\n\nNome da pessoa: %s", pop.pessoas[i].nome);
		printf("\n\nIdade da pessoa: %d", pop.pessoas[i].idade);
		printf("\n\nPeso da pessoa: %.2f", pop.pessoas[i].peso);
	}
	
	free(pop.pessoas);
	
	printf("\n\n\nObrigado por utilizar nosso programa!\n\n");
	system("Pause");
	return 0;
}
