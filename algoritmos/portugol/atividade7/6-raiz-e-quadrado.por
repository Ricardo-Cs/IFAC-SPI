programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		inteiro num = 1, raiz, quadrado
		escreva("Esse programa mostra o quadrado de um valor par, e a raiz quadrada de um valor ímpar!\n")

		enquanto(num > 0) {
			raiz = 0
			quadrado = 0
			
			escreva("Informe o valor: ")
			leia(num)
			
			se(num > 0) {
	
				 se(num % 2 == 0) {
					quadrado = num * num
					escreva("O quadrado de ", num, " é: ", quadrado, "\n\n")
				} senao se(num % 1 == 0) {
					raiz = mat.raiz(num, 2)
					escreva("A raiz quadrada de ", num, " é: ", raiz, "\n\n")
				}
				
			} senao {
				escreva("Fim do programa!")
			}
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 256; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */