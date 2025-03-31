programa
{
	
	funcao inicio()
	{
		inteiro num, i
		escreva("Esse programa imprime a tabuada de um número!\n")

		escreva("Informe o número que deseja ver a tabuada: ")
		leia(num)
		limpa()
		
		para(i = 1; i <= 10; i++) {
			escreva(i, " x ", num, " = ", i * num, "\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 196; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */