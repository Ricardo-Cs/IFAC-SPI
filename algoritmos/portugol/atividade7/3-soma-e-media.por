programa
{
	
	funcao inicio()
	{
		inteiro num = 1, pares = 0, impares = 0, contador = 0
		escreva("Esse programa mostra a soma dos valores pares e a média dos valores ímpares de uma sequência de valores!\n")

		enquanto(num > 0) {
			num = 0
			escreva("Informe um número: ")
			leia(num)

			se(num > 0) {
				se(num % 2 == 0) {
					pares = pares + num
				} senao se(num % 1 == 0) {
					impares = impares + num
					contador++
				}

			}
		}

		se(contador == 0) {
			contador = 1	
		}
		
		escreva("Soma dos pares: ", pares, "\nMédia dos ímpares: ", impares / contador)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 437; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */