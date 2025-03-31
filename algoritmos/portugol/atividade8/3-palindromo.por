programa
{
	inclua biblioteca Texto --> txt
	
	funcao inicio()
	{
		cadeia texto, texto2 = ""
		escreva("Esse programa verifica se uma palavra é um palíndromo!\n")
		escreva("Informa a palavra: ")
		leia(texto)

		texto = txt.caixa_alta(texto)
		para(inteiro i = txt.numero_caracteres(texto) - 1; i >= 0; i--) {
			texto2 = texto2 + txt.obter_caracter(texto, i)
		}
		

		texto2 = txt.caixa_alta(texto2)
		se(texto == texto2) {
			escreva("É um Palíndromo!")
		} senao {
			escreva("Não é palíndromo!")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 500; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */