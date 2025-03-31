programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		real ch, faltas, porcentagemFaltas, n1, n2, n3, n4, nFinal, media
		escreva("\nEsse programa diz se um aluno reprovou em uma materia, com base em suas notas e faltas.\n")
		
		escreva("Informe a quantidade de encontros totais da matéria: ")
		leia(ch)
		
		escreva("\nInforme a sua quantidade de faltas: ")
		leia(faltas)
		limpa()

		porcentagemFaltas = mat.arredondar(faltas * 100 / ch, 1)
			
		se(porcentagemFaltas >= 25) { 
			escreva("O aluno reprovou por faltas!")
		} senao {
			escreva("Informe as quatro notas do aluno: ")
			leia(n1, n2, n3, n4)
			limpa()

		
			media = mat.arredondar((n1 + n2 + n3 + n4) / 4, 1)
	
			se(n1 > 10 ou n2 > 10 ou n3 > 10 ou n4 > 10 ou n1 < 0 ou n2 < 0 ou n3 < 0 ou n4 < 0) {
				escreva("As notas inseridas são inválidas! Tente novamente")
			} senao {
				se(media >= 7) {
			 		escreva("O aluno foi aprovado com média ", media)
			 	} senao {
			 		escreva("O aluno ficou de recuperação! Informe a nota da prova final: ")
			 		leia(nFinal)
			 		limpa()
	
				 	se(nFinal >= media - 10){
				 		escreva("O aluno passou na final e não reprovou!")
				 	} senao {
				 		escreva("O aluno reprovou na materia!")
				 	}
				 }
			  }
		}
		
		
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 560; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */