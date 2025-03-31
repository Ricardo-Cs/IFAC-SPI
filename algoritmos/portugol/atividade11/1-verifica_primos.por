programa
{
	
	funcao inicio()
	{	
		inteiro valor
		logico verifica
		escreva("Esse programa verifica se um número é primo!\n")
		escreva("Informe o valor para verificar: ")
		leia(valor)
		
		verifica = verifica_primo(valor)
		
		limpa()
		se(verifica) escreva("O valor ", valor, " é primo!")
		senao escreva("O valor ", valor, " não é primo!")
	}

	funcao logico verifica_primo(inteiro valor) {
		inteiro divisores = 0
		para(inteiro i = 1; i <= valor; i++) {
			se(valor % i == 0) {
				divisores++	
			}
		}

		se(divisores == 2) retorne verdadeiro
		senao retorne falso
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 483; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */