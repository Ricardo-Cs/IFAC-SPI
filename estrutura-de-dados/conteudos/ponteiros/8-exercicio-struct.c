#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

struct Aluno {
	char nome[80];
	int idade;
	float peso;
};

struct Turma {
	struct Aluno *alunos;
	int quant_alunos;
};

typedef struct Turma Turma;
typedef struct Aluno Aluno;

Turma turma;

int ind = 0;

void clear() {
	printf("\n\n\n");
	system("pause");
	system("cls");
}

int menu() {
	int op;
	printf("\n\n\t\tMenu");
	printf("\n\n\n1 - Cadastrar novo aluno");
	printf("\n\n2 - Listar alunos cadastrados");
	printf("\n\n4 - Alterar cadastro de aluno");
	printf("\n\n5 - Excluir cadastro de aluno");
	printf("\n\n0 - Sair");
	printf("\n\n\nInforme a op√ß√£o desejada: ");
	scanf("%d", &op);
	return op;
}

void cadastrarAluno() {
	printf("\n\n\t\tCadastrar novo aluno");
	printf("\n\nInforme o nome do aluno: ");
	scanf(" %[^\n]", &turma.alunos[ind].nome);
	printf("\n\nInforme a idade do aluno (anos completos): ");
	scanf("%d", &turma.alunos[ind].idade);
	printf("\n\nInforme o peso do aluno (kg): ");
	scanf("%f", &turma.alunos[ind].peso);
	ind++;
	clear();
}

void listarAlunos() {
	int i = 0;
	printf("\n\n\n\tLista de alunos");
	for(i = 0; i < ind; i++) {
		printf("\n\n\nNome do aluno: %s", turma.alunos[i].nome);
		printf("\n\nIdade do aluno: %d", turma.alunos[i].idade);
		printf("\n\nPeso do aluno: %.2f", turma.alunos[i].peso);
	}
	clear();
}

void pesquisarAluno() {
	printf("\n\nPesquisar alunos");
}

void alterarCadastro() {
	printf("\n\nAlterar cadastro");
}

void excluirCadastro() {
	printf("\n\nExcluir cadastro");
}

int main(int argc, char *argv[]) {
	system("cls");
	setlocale(LC_ALL, "Portuguese");
	int op = 1;
	turma.alunos = (Aluno *) malloc(2 * sizeof(Aluno));
	printf("\n\n\n\t\t\tSistema AcadÍmico X!");
	clear();
	
	while(op != 0) {
		op = menu();
		system("cls");
		switch(op) {
			case 1:
				cadastrarAluno();
				break;
			case 2: 
				listarAlunos();
				break;
			case 3: 
				pesquisarAluno();
				break;
			case 4: 
				alterarCadastro();
				break;
			case 5: 
				excluirCadastro();
				break;
			case 0:
				printf("\n\nPrograma finalizado!");
				break;
			default:
				printf("\n\nInforme uma opÁ„o v·lida!");
		}
	}
	
	printf("\n\n\nObrigado por utilizar nosso programa!\n\n");
	system("Pause");
	return 0;
}
