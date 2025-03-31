programa
{
	inclua biblioteca Tipos	
	funcao inicio()
	{
		real dados[5][4], maior = -1.0, matriculaMaior = 0.0, mediaFinal = 0.0
		escreva("Esse programa mostra as informações dos alunos de uma disciplina!\n")

		para(inteiro i = 0; i < 5; i++) {
			escreva("Aluno ", i + 1)
			escreva("\nInforme o número da matrícula do aluno: ")
			leia(dados[i][0])
			escreva("\nInforme a média das provas do aluno: ")
			leia(dados[i][1])
			escreva("\nInforme a média dos trabalhos do aluno: ")
			leia(dados[i][2])
			dados[i][3] = dados[i][1] + dados[i][2]
		
			se(dados[i][3] > maior) {
				maior = dados[i][3]
				matriculaMaior = dados[i][0]
			}

			mediaFinal += dados[i][3]
			limpa()
		}
		
		escreva("Matrícula do aluno com a maior média (", maior, "): ", Tipos.real_para_inteiro(matriculaMaior))
		escreva("\nMédia aritmética das notas finais: ", mediaFinal / 5)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 411; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */