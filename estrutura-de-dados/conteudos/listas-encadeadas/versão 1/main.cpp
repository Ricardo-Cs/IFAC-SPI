#include "ListaEncadeadaFuncs.h"

int main(void) {
	setlocale(LC_ALL, "Portuguese");
	int control = 1, op;
	
	// Errado
	int id, idade;
	char nome[80];
	float peso;
	Pessoa* pessoa;
	
	while(control) {
		op = menu();
		
		system("cls");
		switch (op) {
			case 1:
				printf("\n\n\n\tOpção desejada: Criar Lista Encadeada");
				pessoa = criarLista();
				printf("\n\nLista encadeada criada com sucesso!\n\n");
				system("Pause");
				break; 
			case 2:
				printf("\n\n\n\tOpção desejada: Inserir Registro em Lista Encadeada");
				printf("\n\nInforme o ID da pessoa: ");
				scanf("%d", &id);
				fflush(stdin);
				printf("\n\nInforme o nome da pessoa: ");
				gets(nome);
				printf("\n\nInforme o peso da pessoa: ");
				scanf("%f", &peso);
				printf("\n\nInforme a idade da pessoa: ");
				scanf("%d", &idade);
				
				pessoa = inserirLista(pessoa, id, nome, peso, idade);
				
				printf("\n\nPessoa registrada com sucesso!\n\n");
				system("Pause");
				break;
			case 3: // Alterar Registro na Lista
				break;
			case 4:
				
				break;
			case 5:
				printf("\n\n\n\tOpção desejada: Listar Registros de Lista Encadeada");
				imprimirLista(pessoa);
				system("Pause");
				break;
			case 6:
				break;
			case 7:
				break;
			case 8:
				printf("\n\n\n\tOpção desejada: Liberar Lista Encadeada");
				if(liberarLista(pessoa) == NULL) 
					printf("\n\nLista Encadeada liberada com sucesso!\n\n");
				else 
					printf("\n\nFalha no processo de liberação de lista encadeada!\n\n");
				system("Pause");
				break;
			case 0:
				printf("\n\nVocê optou em sair!");
				control = 0;
				break;
		}
	}

	
	printf("\n\nObrigado por utilizar nosso programa!\n\n");
	system("Pause");
	return 0;
}
