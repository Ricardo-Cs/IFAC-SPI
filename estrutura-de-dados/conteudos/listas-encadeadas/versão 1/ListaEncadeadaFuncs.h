#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>

struct pessoa {
	int id;
	char nome[80];
	float peso;
	int idade;
	struct pessoa* prox;
};

typedef struct pessoa Pessoa;

Pessoa* criarLista() {
	return NULL;
}

Pessoa* inserirLista(Pessoa* p, int novoId, char* novoNome, float novoPeso, int novaIdade) {
	pessoa* novo = (pessoa*) malloc(sizeof(Pessoa*));
	novo->id = novoId;
	strcpy(novo->nome, novoNome);
	novo->idade = novaIdade;
	novo->peso = novoPeso;
	novo->prox = p;
}

void imprimirLista(Pessoa* p) {
	pessoa* pe;
	for(pe = p; pe != NULL; pe = pe->prox) {
		printf("\n\n\n\tLista de Pessoas");
		printf("\n\n\nId da pessoa: %d", pe->id);
		printf("\n\nNome da pessoa: %s", pe->nome);
		printf("\n\nPeso da pessoa: %.2f", pe->peso);
		printf("\n\nIdade da pessoa: %d\n\n", pe->idade);
	}
}

Pessoa* buscaElemento(Pessoa* p, int id) {
	pessoa* pe;
	for(pe = p; pe != NULL; pe = pe->prox) {
		if(pe->id == id) return pe;
	}
	return NULL;
}

int listaVazia(Pessoa* p) {
	if(p == NULL) return 0;
	return 1;
}

Pessoa* removerElemento(Pessoa* p, int id) {
	Pessoa* pe = p;
	Pessoa* ant = NULL;
	
	while(pe != NULL && pe->id != id) {
		ant = pe;
		pe = pe->prox;
	}
	
	// Lista vazia ou elemento não encontrado
	if(pe == NULL) return p;
	
	// Elemento encontrado
	if(ant == NULL) // Elemento encontrado é o "primeiro" da lista
		p = pe->prox;
	else 
		ant->prox = pe->prox;
	
	free(pe);
	return p;
}

Pessoa* liberarLista(Pessoa* p) {
	Pessoa* pe = p;
	while(pe != NULL) {
		Pessoa* p1 = pe->prox;
		free(pe);
		pe = p1;
	}
	
	return p;
}

int compararListas(Pessoa* p1, Pessoa* p2) {
	bool verifica = true;
	Pessoa* pe1 = p1;
	Pessoa* pe2 = p2;
	
	while(p1 != NULL && p2 != NULL) {
		if(p1->id != p2->id) return 0;
		pe1 = pe1->prox;
		pe2 = pe2->prox;
	}
	
	return pe1 == pe2; // NULL == NULL
}

int menu() {
	int op;
	system("cls");
	printf("\n\nEsse programa manipula listas encadeadas!");
	printf("\n\n\n\tMENU");
	printf("\n\n\n1 - Criar Lista Encadeada");
	printf("\n\n2 - Inserir Registro em Lista Encadeada");
	printf("\n\n3 - Alterar Registro em Lista Encadeada");
	printf("\n\n4 - Remover Registro em Lista Encadeada");
	printf("\n\n5 - Listar Registros de Lista Encadeada");
	printf("\n\n6 - Buscar Registro em Lista Encadeada");
	printf("\n\n7 - Verificar se Lista Encadeada Vazia");
	printf("\n\n8 - Liberar Lista Encadeada");
	printf("\n\n0 - Sair");
	printf("\n\n\n\nInforme a opção desejada: ");
	scanf("%d", &op);
	return op;
}

// 1 - Função para vrificar repetições de id na lista
// 2 - (Mais desafiadora) Função para comparar duas listas com base em um campo definido pelo usuário
// 3 - Função de ordenação da lista com base no id - crescente ou decrescente
// 4 - Função de busca binária após a ordenação com base no id
// 5 - Montar a estrutura de cada registro com o id autoincrementado
// 6 - Função para vincular/concatenar duas listas de mesma estrutura em uma lista única
// 7 - Função para alterar campos de um registro (busca) na lista - editar









