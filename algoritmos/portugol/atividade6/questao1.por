programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		real minutos
		escreva("Esse programa transforma um valor em minutos para horas e segundos!\n")

		escreva("Informe um valor em minutos: ")
		leia(minutos)
		limpa()

		se(minutos >= 0) {
			escreva("Minutos: ", mat.arredondar(minutos, 2), "\nSegundos: ", mat.arredondar(minutos * 60, 2), "\nHoras: ", mat.arredondar(minutos / 60, 2))
		} senao {
			escreva("O valor informado é inválido! Tente novamente.")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 419; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */