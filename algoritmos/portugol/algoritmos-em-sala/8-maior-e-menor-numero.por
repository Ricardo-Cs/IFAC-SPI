programa
{
	
	funcao inicio()
	{
		inteiro i, qtdNum
		real maior = -99999999999.0, menor = 99999999999.0, atual
		escreva("Esse programa informa o maior e menor em uma sequência de números!\n")

		escreva("Informe a quantidade de números: ")
		leia(qtdNum)
		limpa()

		para(i = 1; i <= qtdNum; i++) {
			escreva("Informe o ", i, "° número: ")
			leia(atual)

			se(atual > maior) {
				maior = atual
			} 
			se(atual < menor){
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
 * @POSICAO-CURSOR = 194; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */