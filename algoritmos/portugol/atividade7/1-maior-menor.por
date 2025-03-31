programa
{
	
	funcao inicio()
	{
		inteiro qtd, i
		real maior = -999999999.0, menor = 999999999.0, atual
		escreva("Esse programa verifica o maior e menor número em uma sequeência!\n")

		escreva("Informe a quantidade de números: ")
		leia(qtd)
		limpa()

		para(i = 1; i <= qtd; i++) {
			escreva("Informe o ", i, "° número: ")
			leia(atual)
			
			se(atual > maior) {
				maior = atual
			}

			se(atual < menor) {
				menor = atual
			}
		}

		escreva("Maior número: ", maior, "\nMenor número: ", menor)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 281; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */