programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		real valor
		escreva("Esse programa converte a moeda brasileira em outras moedas!\n")

		escreva("Informe o valor em reais: ")
		leia(valor)
		limpa()

		se(valor > 0) {
			// Cotação do dia 17/07/2024
			escreva("Real brasileiro (BRL): ", valor, "\nDólar americano (USD): ", mat.arredondar(valor / 5.49, 2), "\nLibra esterlina (GBP): ", mat.arredondar(valor / 7.14, 2), "\nYuan chinês (CNY): ", mat.arredondar(valor / 0.76, 2), "\nEuro (EUR): ", mat.arredondar(valor / 6, 2))
		} senao {
			escreva("Valor inválido! Tente novamente.")
		}

		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 606; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */