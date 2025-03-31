programa
{
	
	funcao inicio()
	{	
		inteiro i, j, num
		escreva("Esse programa imprime todas as tabuadas até um número n!\n")

		escreva("Informe o número: ")
		leia(num)
		limpa()

		para(i = 1; i <= num; i++) {
			escreva("Tabuada do ", i, "\n")
			para(j = 1; j <= 10; j++) {
				escreva(i, " x ", j, " = ", i * j, "\n")
			}
			escreva("\n")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 359; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */