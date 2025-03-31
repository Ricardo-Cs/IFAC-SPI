programa
{
	
	funcao inicio()
	{
		inteiro i, j, qtd, menor = 99999999, maior = -99999999, num1, num2, soma = 0
		escreva("Esse programa calcula o somatório de uma sequência de pares de números!\n")
	
		escreva("Informe a quantidade de pares: ")
		leia(qtd)
		limpa()

		para(i = 0; i < qtd; i++) {
			soma = 0
			escreva("Informe o par de valores: ")
			leia(num1, num2)

			se(num1 > num2) {
				maior = num1
				menor = num2
			} 
			se(num1 < num2) {
				maior = num2
				menor = num1
			}

			para(j = menor; j <= maior; j++) {
				soma = soma + j
			}

			escreva("A soma dos valores entre ", menor, " e ", maior, " é: ", soma, "\n\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 316; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */