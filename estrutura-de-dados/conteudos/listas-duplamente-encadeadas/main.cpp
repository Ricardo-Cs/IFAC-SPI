#include "ListaDupEncadeadaPessoa.h"

int main() {
	Pessoa* lista = criarLista();
	char nome[80] = "Ricardo";
	lista = inserirInicio(lista, 1, nome, 90.0, 19);
	lista = inserirInicio(lista, 2, nome, 80.0, 20);
	lista = inserirFim(lista, 3, nome, 40.0, 12);
	lista = inserirMeio(lista, 2, 10, nome, 45.3, 14);
	
	imprimirListaDireta(lista);
//	imprimirListaInversa(lista);
//	lista = liberarLista(lista);
//	lista = removerPorId(lista, 10);
	
//	if(buscarPorId(lista, 1))
//		printf("Achou\n");
//	else 
//		printf("Não achou\n");
}
