programa
{
	
	funcao inicio()
	{
	
		inteiro ano, verifica
		escreva("Esse programa verifica se um ano é bissexto!\n")
		escreva("Informe o ano para verificar: ")
		leia(ano)
		
		verifica = verifica_bissexto(ano)
		
		limpa()
		se(verifica == 1) escreva("O ano é bissexto!")
		senao escreva("O ano não é bissexto!")
	}

	funcao inteiro verifica_bissexto(inteiro ano) {
		se(ano % 4 == 0 e (ano % 100 != 0 ou ano % 400 == 0)) {
			retorne 1	
		}
		retorne 0
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 424; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */