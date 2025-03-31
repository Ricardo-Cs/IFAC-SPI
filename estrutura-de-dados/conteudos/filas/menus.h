int menu () {
	int op;
	system ("cls");
	printf ("\n\n\n\tMenu Principal");
	printf ("\n\n\n1 - Enfileirar Cadastro de Aluno");
	printf ("\n\n2 - Desenfileirar Cadastro de Aluno");
	printf ("\n\n3 - Exibir Fila de Cadastros de Alunos");
	printf ("\n\n0 - Sair");
	printf("\n\n\nEscolha uma opção: ");
    scanf("%d", &op);
    return op;
}

void clear (void) {
	printf ("\n\n\n");
	system ("Pause");
	system ("cls");
}
