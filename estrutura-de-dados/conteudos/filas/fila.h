#define MAX 100

typedef struct {
	char nome[MAX];
	int matricula;
	int codCurso;
	char tipoCurso[MAX];
	int idade;
	float coedMediaGeral;
} Aluno;

// Estrutura do Nó da fila
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
		printf("\n\nErro de alocação de memória!\n\n");
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
		printf("\n\nA fila está vazia!\n\n");
		exit(1);
	}
	
	No* temp = fila->frente; // Endereço do primeiro elemento
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
		printf("\n\nA fila está vazia!\n\n");
		return;
	}
	
	No* atual = fila->frente;
	printf("\n\n\n\tRelatório da Fila");
	while(atual != NULL) {
		Aluno alunoAtual = atual->aluno;
		printf("\n\n\n\nNome do aluno: %s.", alunoAtual.nome);
		printf("\n\nNúmero da matrícula: %d.", alunoAtual.matricula);
		printf("\n\nCódigo do curso: %d.", alunoAtual.codCurso);
		printf("\n\nTipo do curso: %s.", alunoAtual.tipoCurso);
		printf("\n\nIdade: %d.", alunoAtual.idade);
		printf("\n\nMédia geral de notas: %.2f.", alunoAtual.coedMediaGeral);
		atual = atual->prox;
	}
}
