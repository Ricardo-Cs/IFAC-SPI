programa
{
	
	funcao inicio()
	{
		inteiro i, num, div = 0
		escreva("Esse programa verifica se um número é primo!\n")

		faca {
			div = 0
			
			escreva("Informe o número para verificar: ")
			leia(num)
			limpa()
	
			para(i = 1; i <= num; i++) {
				se(num % i == 0) {
					div++
				}
			}
	
			se(div == 2) {
				escreva("Esse número é primo!")
			} senao {
				escreva("Esse número não é primo!")
			}

			escreva("\n")
		} enquanto (num > 0)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 135; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */