programa
{
	
	funcao inicio()
	{
		inteiro i, num = 1, fatorial
		escreva("Esse programa mostra o fatorial de um número!\n")
	
		enquanto(num > 0) {
			fatorial = 1
			escreva("Informe o número: ")
			leia(num)
				
			se(num > 0) {
				para(i = num; i >= 1; i--) {
					fatorial = fatorial * i
				}
	
				escreva("O fatorial de ", num, " é: ", fatorial, "\n\n")
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
 * @POSICAO-CURSOR = 300; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */