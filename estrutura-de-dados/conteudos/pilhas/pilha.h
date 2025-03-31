// Capacidade máxima da Pilha
#define MAX 100

typedef struct {
	int codLivro;
	char nome[100];
	char issn[10];
	char autor[10];
	int quantPaginas;
	float preco;
} Livro;

typedef struct {
	Livro livros[MAX];
	int topo;
} Pilha;


void inicializarPilha(Pilha *p) {
	p->topo = -1;
}

int pilhaVazia(Pilha *p) {
	return p->topo == -1;
}

int pilhaCheia(Pilha *p) {
	return p->topo == MAX - 1;
}

void empilhar(Pilha *p, Livro livro) {
	if(pilhaCheia(p)) {
		printf("\n\nNão é possível empilhar! A pilha está cheia!");
		return;
	}
	
	p->livros[++(p->topo)] = livro;
}

Livro desempilhar(Pilha *p) {
	if(pilhaVazia(p)) {
		printf("\n\nA pilha está vazia!");
		Livro livroHip = {0, "", "", "", 0, 0.0};
		return livroHip;
	}
	
	return p->livros[(p->topo)--];
}

Livro topoPilha(Pilha *p) {
	if(pilhaVazia(p)) {
		printf("\n\nA pilha está vazia!");
		Livro livroHip = {0, "", "", "", 0, 0.0};
		return livroHip;
	}
	
	return p->livros[p->topo];
}

int tamanhoPilha(Pilha *p) {
	if(pilhaVazia(p)) {
		printf("\n\nA pilha está vazia!");
		return 0;
	}
	
	return p->topo + 1;
}

void exibirPilha(Pilha *p) {
	if(pilhaVazia(p)) {
		printf("\n\nA pilha está vazia!");
		return;
	}
	
	printf("\n\n\n\tLivros na Pilha");
	for(int i = p->topo; i >= 0; i--) {
		printf("\n\n\nCódigo do Livro: %d", p->livros[i].codLivro);
		printf("\n\nNome do Livro: %s", p->livros[i].nome);
		printf("\n\nNome do Autor: %s", p->livros[i].autor);
		printf("\n\nNúmero do ISSN: %s", p->livros[i].issn);
		printf("\n\nQuantidade de Páginas: %d", p->livros[i].quantPaginas);
		printf("\n\nPreço do Livro: R$ %.2f", p->livros[i].preco);
	}
}

Livro carregarLivro() {
	Livro livro;
	
	printf("\n\n\nInforme o código do Livro: ");
	scanf("%d", &livro.codLivro);
	fflush(stdin);
	printf("\n\nInforme o nome do Livro: ");
	fgets(livro.nome, MAX, stdin);
	livro.nome[strcspn(livro.nome, "\n")] = '\0';
	printf("\n\nInforme o ISSN do Livro: ");
	fgets(livro.issn, 10, stdin);
	livro.issn[strcspn(livro.issn, "\n")] = '\0';
	printf("\n\nInforme o nome do autor do Livro: ");
	fgets(livro.autor, MAX, stdin);
	livro.autor[strcspn(livro.autor, "\n")] = '\0';
	printf("\n\nInforme a quantidade de páginas do Livro: ");
	scanf("%d", &livro.quantPaginas);
	printf("\n\nInforme o valor do Livro: ");
	scanf("%f", &livro.preco);
	
	return livro;
}
