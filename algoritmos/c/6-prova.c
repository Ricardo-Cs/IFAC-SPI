#include <stdio.h>
#include <stdlib.h>
#include <locale.h>

int main() {
	setlocale(LC_ALL, "Portuguese");
	int matricula[3], notas[3], i, j;
	char dados[3][10], gabarito[10] = { 'a', 'a', 'd', 'b', 'c', 'c', 'b', 'e', 'e', 'b' };
	float aprovacao = 0; 
	printf("Esse programa corrige uma prova e retorna os dados da mesma!\n");
	
	for(i = 0; i < 3; i++) {
		int nota = 0;
		printf("Informe a matrícula do %d° aluno: ", i + 1);
		scanf("%d", &matricula[i]);
		
		for(j = 0; j < 10; j++) {
			char resposta;
			printf("Informe a resposta da questão %d: ", j + 1); 
			scanf(" %c", &resposta); 
			dados[i][j] = resposta;
			
			if(resposta != 'a' && resposta != 'b' && resposta != 'c' && resposta != 'd' && resposta != 'e') {
				printf("Resposta inválida! Tente novamente.\n");
				j--;
			} else {
				if(resposta == gabarito[j]) {
					nota++;
				}
			}
		}
		notas[i] = nota;
		system("cls");
	}
	system("cls");
	printf("\tDados dos alunos: \n");
	printf("Gabarito: [ ");
	for(i = 0; i < 10; i++) printf(" %c ", gabarito[i]); 
	printf("]\n\n");
	
	for(i = 0; i < 3; i++) {
		printf("Aluno %d \n", i + 1);
		printf("Matrícula: %d \n", matricula[i]);
		printf("Respostas: [ ");
		for(j = 0; j < 10; j++) {
			printf(" %c ", dados[i][j]);
		}
		printf("]");
		printf("\nNota: %d\n\n", notas[i]);
	}
	printf("Percentual de aprovação: ");
	for(i = 0; i < 3; i++) {
		if(notas[i] >= 7) {
			aprovacao++;
		}
	}
	printf("%.2f%%", (aprovacao / 3) * 100); 
	
	return 0;
}

