programa
{
	
	funcao inicio()
	{
	
		inteiro valor
		logico verifica
		escreva("Esse programa verifica se um número é perfeito!\n")
		escreva("Informe o valor para verificar: ")
		leia(valor)
		
		verifica = verifica_perfeito(valor)
		
		limpa()
		se(verifica) escreva("O valor ", valor, " é perfeito!")
		senao escreva("O valor ", valor, " não é perfeito!")
	}

	funcao logico verifica_perfeito(inteiro valor) {
		inteiro divisores = 0
		para(inteiro i = 1; i < valor; i++) {
			se(valor % i == 0) {
				divisores += i	
			}
		}

		se(divisores == valor) retorne verdadeiro
		senao retorne falso
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 436; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */