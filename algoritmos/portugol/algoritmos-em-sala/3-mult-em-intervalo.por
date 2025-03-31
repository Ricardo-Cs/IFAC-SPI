programa
{
	
	funcao inicio()
	{
		inteiro i, final, contador = 0, mult
		
		escreva("Informe o número inicial: ")
		leia(i)

		escreva("Informe o número final: ")
		leia(final)

		escreva("Informe o múltiplo de quais números deseja encontar: ")
		leia(mult)		
		
		para(i; i <= final; i++) {
			se(i % mult == 0) {
				escreva("\t", i, "\n")
				contador++
			}
		}

		escreva("Quantidade de números: ", contador)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 243; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */