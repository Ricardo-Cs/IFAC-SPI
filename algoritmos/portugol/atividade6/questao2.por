programa
{
	
	funcao inicio()
	{
		real base, altura
		escreva("Esse programa calcula a área e o perímetro de um retângulo!\n")
		escreva("Informe o valor da base do retângulo: ")
		leia(base)
		
		escreva("Informe o valor da altura do retângulo: ")
		leia(altura)
		limpa()

		se(base > 0 e altura > 0) {
			escreva("Área: ", base * altura, "\nPerímetro: ", 2 * (base * altura))
		} senao {
			escreva("Valores inválidos! Tente novamente.")
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 451; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */