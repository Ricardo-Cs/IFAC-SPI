programa
{
	
	funcao inicio()
	{
		inteiro termos, i
		real inicial, razao
		escreva("Esse programa imprime todos os termos de uma P.A\n")

		escreva("Informe a quantidade de termos da P.A: ")
		leia(termos)
		escreva("Informe a razão da P.A: ")
		leia(razao)
		escreva("Informe o termo inicial da P.A: ")
		leia(inicial)
		limpa()

		escreva("P.A: ")
		para(i = 0; i < termos; i++) {
			escreva(inicial, ", ")
			inicial = inicial + razao
		}
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 415; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */