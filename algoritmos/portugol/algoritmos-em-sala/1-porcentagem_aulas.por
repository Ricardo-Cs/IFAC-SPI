programa
{
	inclua biblioteca Matematica
	
	funcao inicio()
	{
		cadeia materia
		real cargaHoraria, aulasMinistradas, porcentagemFalta
		escreva("Esse programa calcula a quantidade de aulas que faltam para terminar uma matéria!.\n")
		escreva("Informe o nome da matéria: ")
		leia(materia)
		limpa()

		escreva("Informe a quantidade de encontros totais dessa matéria: ")
		leia(cargaHoraria)
		limpa()

		escreva("Informe a quantidade de aulas já ministradas: ")
		leia(aulasMinistradas)
		limpa()

		se(aulasMinistradas < cargaHoraria) {
			porcentagemFalta = Matematica.arredondar(aulasMinistradas * 100 / cargaHoraria, 1)
			escreva("A carga horária ministrada de ", materia, " foi de ", porcentagemFalta, "%. Faltam ", 100 - porcentagemFalta, "% para finalizar a matéria!")
		} senao {
			escreva("Os dados informados são inválidos! Tente novamente.")
		}

		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 866; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */