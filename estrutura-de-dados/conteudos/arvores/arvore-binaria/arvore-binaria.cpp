#include <stdio.h>
#include <locale.h>
#include <stdlib.h>

typedef struct no {
	int chave;
	struct no *esquerda;
	struct no *direita;
} no;

void inserirNo(no **raiz, int elemento) {
	if (*raiz == NULL) { // 1� caso - Inserindo no raiz
		no *aux = (no *) malloc(sizeof(no));
		aux->chave = elemento;
		aux->direita = aux->esquerda = NULL;
		*raiz = aux;
		system("cls");
		printf("\n\n\nElemento inserido com sucesso na �rvore bin�ria!");
		return;
	}
	
	if (elemento > (*raiz)->chave) { // 2� caso - inserindo a esquerda
		inserirNo(&(*raiz)->esquerda, elemento);
		system("cls");
		printf("\n\n\nElemento inserido com sucesso na �rvore bin�ria!");
		return;
	}
	
	if (elemento < (*raiz)->chave) {// 2� caso - inserindo a direita
		inserirNo(&(*raiz)->direita, elemento);
		system("cls");
		printf("\n\n\nElemento inserido com sucesso na �rvore bin�ria!");
		return;
	}
	
	printf("\n\n\nO c�digo de elemento %d � uma repeti��o! Elemento n�o inserido na �rvore bin�ria!");
}

int main() {
	system("cls");
	setlocale(LC_ALL, "Portuguese");
	no *raiz = NULL;
	inserirNo(&raiz, 10);
	inserirNo(&raiz, 12);
	inserirNo(&raiz, 14);
	
	printf("\n\n\nObrigado por utilizar o nosso programa\n\n");
	system("pause");
	return 0;
}
