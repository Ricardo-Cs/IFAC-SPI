programa
{
	
	funcao inicio()
	{
		real a, b, total
		escreva("Esse algoritmo faz algumas operações com dois números reais ('a' e 'b').\n")
		escreva("Informe o valor de a: ")
		leia(a)

		escreva("Informe o valor de b: ")
		leia(b)
		limpa()

		se(a == b)
			escreva("O quadrado de a é: ", a * a)

		se(a > b)
			escreva("O resultado de a + b é: ", a + b)

		se(a < b)
			escreva("O resultado de b - a é: ", b - a)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 248; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */