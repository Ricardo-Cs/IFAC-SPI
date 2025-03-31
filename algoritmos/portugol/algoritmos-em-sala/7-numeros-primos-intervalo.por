programa
{
	
	funcao inicio()
	{
		inteiro i, j, inicial, final, div
		escreva("Esse programa encontra os números primos em um intervalo!\n")

		escreva("Informe o valor inicial do intervalo: ")
		leia(inicial)

		escreva("Informe o valor final do intervalo: ")
		leia(final)
		limpa()

		escreva("Primos: \n")
		para(i = inicial; i <= final; i++) {
			div = 0
			para(j = 1; j <= i; j++) {
				se(i % j == 0) {
					div++
				}
			}
			se(div == 2) {
				escreva(i, "\n")
			}
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 481; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */