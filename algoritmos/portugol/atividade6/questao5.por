programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{	
		real minutos
		escreva("Esse programa determina o valor final de uma fatura telefônica!\n")

		escreva("Informe a quantidade de minutos de ligação usada nesse mês: ")
		leia(minutos)
		limpa()

		se (minutos <= 6000) {
			escreva("O valor da fatura continua R$ 70.00!")
		} senao {
			escreva("Você ultrapassou ", mat.arredondar(minutos - 6000, 2), " minutos do limite do plano! A fatura final será de R$ ", mat.arredondar(70 + ((minutos - 6000) * 0.13), 2))
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 294; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */