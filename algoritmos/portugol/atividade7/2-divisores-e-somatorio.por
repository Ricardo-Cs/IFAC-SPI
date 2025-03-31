programa
{
	
	funcao inicio()
	{
		inteiro qtd, i, j, num, div, soma
		
		escreva("Esse programa apresenta a quantidade de divisores e o somatório de uma sequência de números!\n")
	
		escreva("Informe a quantidade de valores: ")
		leia(qtd)
		limpa()
	
		para(i = 1; i <= qtd; i++) {
			soma = 0
			div = 0
			escreva("Informe o ", i, "° número: ")
			leia(num)

			para(j = 1; j <= num; j++) {
				se(num % j == 0) {
					div++
				}

				soma = soma + j
			}

			escreva("Quantidade de divisores: ", div, "\n")
			escreva("Somatório de 1 a ", num, ": ", soma, "\n\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 68; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */