#define MAX 100

typedef struct {
	char nome[MAX];
	int matricula;
	int codCurso;
	char tipoCurso[MAX];
	int idade;
	float coedMediaGeral;
} Aluno;

// Estrutura do N� da fila
typedef struct No {
	Aluno aluno;
	struct No* prox; // Se refere ao proximo da fila
} No;

// Estrutura da fila
typedef struct {
	No* frente;
	No* tras;
} Fila;

void inicializarFila(Fila* fila) {
	fila->frente = NULL;
	fila->tras = NULL;
}

int filaVazia(Fila* fila) {
	return fila->frente == NULL;
}

void enfileirar(Fila* fila, Aluno aluno) {
	No* novoNo = (No*) malloc(sizeof(No));
	if(novoNo == NULL) {
		printf("\n\nErro de aloca��o de mem�ria!\n\n");
		exit(1);
	}
	
	novoNo->aluno = aluno;
	novoNo->prox = NULL;
	
	if(filaVazia(fila)) {
		fila->frente = novoNo;
	} else {
		fila->tras->prox = novoNo;
	}
	
	fila->tras = novoNo;
	printf("\n\nNovo aluno enfileirado com sucesso!\n\n");
}

Aluno desenfileirar(Fila* fila) {
	if(filaVazia(fila)) {
		printf("\n\nA fila est� vazia!\n\n");
		exit(1);
	}
	
	No* temp = fila->frente; // Endere�o do primeiro elemento
	Aluno alunoRemovido = temp->aluno; // Dados do primeiro elemento
	fila->frente = temp->prox;
	
	if(fila->frente == NULL) {
		fila->tras = NULL;
	}
	
	free(temp);
	return alunoRemovido;
}

void exibirFila(Fila* fila) {
	if(filaVazia(fila)) {
		printf("\n\nA fila est� vazia!\n\n");
		return;
	}
	
	No* atual = fila->frente;
	printf("\n\n\n\tRelat�rio da Fila");
	while(atual != NULL) {
		Aluno alunoAtual = atual->aluno;
		printf("\n\n\n\nNome do aluno: %s.", alunoAtual.nome);
		printf("\n\nN�mero da matr�cula: %d.", alunoAtual.matricula);
		printf("\n\nC�digo do curso: %d.", alunoAtual.codCurso);
		printf("\n\nTipo do curso: %s.", alunoAtual.tipoCurso);
		printf("\n\nIdade: %d.", alunoAtual.idade);
		printf("\n\nM�dia geral de notas: %.2f.", alunoAtual.coedMediaGeral);
		atual = atual->prox;
	}
}
