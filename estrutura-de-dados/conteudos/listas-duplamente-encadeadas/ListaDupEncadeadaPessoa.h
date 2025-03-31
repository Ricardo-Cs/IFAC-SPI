#include <stdio.h>
#include <locale.h>
#include <stdlib.h>
#include <string.h>

typedef struct pessoa {
	int id;
	char nome[80];
	int idade;
	float peso;
	struct pessoa* anterior;
	struct pessoa* proximo;
} Pessoa;

Pessoa* criarLista() {
	return NULL;
}

// Nó é um novo registro da lista. Essa função apenas cria o nó, mas não o insere na lista.
Pessoa* criarNo(int id, char* nome, float peso, int idade) { 
	Pessoa* novaPessoa = (Pessoa*)malloc(sizeof(Pessoa));
	if (!novaPessoa) {
        printf("Erro ao alocar memória! Não será possível inserir novo elemento na lista!\n");
        exit(1);
    }
    novaPessoa->id = id;
    strcpy(novaPessoa->nome, nome);
    novaPessoa->idade = idade;
    novaPessoa->peso = peso;
    novaPessoa->anterior = NULL;
    novaPessoa->proximo = NULL;
    return novaPessoa;
}

int listaVazia(Pessoa* lista) {
	return lista == NULL;
}

Pessoa* inserirInicio(Pessoa* lista, int id, char* nome, float peso, int idade) {
	Pessoa* novaPessoa = criarNo(id, nome, peso, idade);
	novaPessoa->proximo = lista;
	if(lista != NULL)
		lista->anterior = novaPessoa;
	return novaPessoa;
}

Pessoa* inserirMeio(Pessoa* lista, int codBusca, int id, char* nome, float peso, int idade) {
	Pessoa* novaPessoa = criarNo(id, nome, peso, idade);
	novaPessoa->anterior = lista;
	
	if(lista == NULL)
		return novaPessoa;
	
	Pessoa* aux = lista;
	while(aux->id != codBusca)
		aux = aux->proximo;
	
	novaPessoa->proximo = aux->proximo;
	aux->proximo->anterior = novaPessoa;
	aux->proximo = novaPessoa;
	novaPessoa->anterior = aux;
	return lista;
}

Pessoa* inserirFim(Pessoa* lista, int id, char* nome, float peso, int idade) {
	Pessoa* novaPessoa = criarNo(id, nome, peso, idade);
	novaPessoa->anterior = lista;
	if(lista == NULL)
		return novaPessoa;
		
	Pessoa* aux = lista;
	//Percorre do início da lista até o final (aux.proximo == NULL)
	while(aux->proximo != NULL)
		aux = aux->proximo;
	
	aux->proximo = novaPessoa;
	novaPessoa->anterior = aux;
	return lista;
}

// Imprimir a lista na ordem direta
void imprimirListaDireta(Pessoa* lista) {
	if (listaVazia(lista)) {
		printf("\n\n\nA lista está vazia!");
		return;
	}
	
	Pessoa* aux = lista;
	printf("\n\n\nLista na Ordem Direta: \n");
	while (aux != NULL) {
        printf("\n\nId: %d", aux->id);
        printf("\nNome: %s", aux->nome);
        printf("\nPeso (kg): %.2f", aux->peso);
        printf("\nIdade: %d", aux->idade);
        aux = aux->proximo;
	}
}

void imprimirListaInversa(Pessoa* lista) {
	if (listaVazia(lista)) {
		printf("\n\n\nA lista está vazia!");
		return;
	}
	
	Pessoa* aux = lista;
	while(aux->proximo != NULL) 
		aux = aux->proximo;
	
	printf("\n\n\nLista na Ordem Inversa: \n");
	while (aux != NULL) {
        printf("\n\nId: %d", aux->id);
        printf("\nNome: %s", aux->nome);
        printf("\nPeso (kg): %.2f", aux->peso);
        printf("\nIdade: %d", aux->idade);
        aux = aux->anterior;
	}
}

Pessoa* buscarPorId(Pessoa* lista, int id) {
	Pessoa* aux = lista;
	while (aux != NULL) {
		if (aux->id == id) 
			return aux;
		aux = aux->proximo;
	}
	return NULL;
}

Pessoa* removerPorId(Pessoa* lista, int id) {
	Pessoa* aux = buscarPorId(lista, id);
	
	if (aux == NULL) {
		printf("\n\n\nPessoa/Registro não localizado na lista!");
		return aux;
	}
		
	if (aux->anterior != NULL) 
		aux->anterior->proximo = aux->proximo;
	else 
		lista = aux->proximo;
	
	if (aux->proximo != NULL)
		aux->proximo->anterior = aux->anterior;
	
	free(aux);
	printf("\n\n\nPessoa/Registro com id %d removido com sucesso!\n\n", id);
	return lista;
}

Pessoa* liberarLista(Pessoa* lista) {
	Pessoa* aux = lista;
	while (aux != NULL) {
		Pessoa* aux2 = aux->proximo;
		free(aux);
		aux = aux2;
	}
	printf("\n\n\nLista liberada com sucesso!\n\n");
	return NULL;
}
