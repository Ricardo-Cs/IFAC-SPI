#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <locale.h>
#include "fila.h"
#include "menus.h"

int main(int argc, char* argv[]) {
	setlocale (LC_ALL, "Portuguese");
	int opcao;
	Fila fila;
    inicializarFila(&fila);
	
	printf ("\n\n\n\tEste programa manipula uma fila de cadastros de alunos!");
    clear();
    
    do {
    	system("cls");
    	opcao = menu();
        
        switch(opcao) {
        	case 1:
        		system("cls");
        		fflush(stdin);
        		printf("\n\n\nOpção Enfileirar Cadastro de Aluno");
        		Aluno aluno;
        		printf("\n\n\nInforme o nome do aluno: ");
        		fgets(aluno.nome, MAX, stdin);
        		aluno.nome[strcspn(aluno.nome, "\n")] = '\0'; // Limpa o \n do final da string
        		printf("\n\nInforme a matrícula do aluno: ");
        		scanf("%d", &aluno.matricula);
        		printf("\n\nInforme o código do curso do aluno: ");
        		scanf("%d", &aluno.codCurso);
        		printf("\n\nInforme o tipo do curso do aluno: ");
        		fflush(stdin);
				fgets(aluno.tipoCurso, MAX, stdin);
        		aluno.tipoCurso[strcspn(aluno.tipoCurso, "\n")] = '\0';
				printf("\n\nInforme a idade do aluno: ");
        		scanf("%d", &aluno.idade);
        		printf("\n\nInforme o coeficiente de aproveitamento do aluno: ");
        		scanf("%f", &aluno.coedMediaGeral);
        		
        		enfileirar(&fila, aluno);
        		break;
        	case 2:
        		system("cls");
        		printf("\n\n\nOpção Desenfileirar Cadastro de Aluno");
        		if(!filaVazia(&fila)) {
        			Aluno removido = desenfileirar(&fila);
					printf("\n\n\nO aluno %s foi desenfileirado!", removido.nome);
				} else 
					printf("\n\n\nA fila de cadastro de alunos está vazia!\n\n");
				
				clear();
        		break;
        	case 3:
        		system("cls");
        		printf("\n\n\nOpção Exibir Fila de Cadastros de Alunos");
        		exibirFila(&fila);
        		clear();
        		break;
        	case 0: 
        		printf("\n\n\nVocê optou em sair!\n\n");
        		clear();
        		break;
			default:
				printf("\n\n\nInforme uma opção válida!");
		}
	} while(opcao != 0);
	
	printf("\n\n\nObrigado por utilizar nosso programa!\n\n");
	system("cls");
	return 0;
}

