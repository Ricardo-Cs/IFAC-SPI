programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		real a, b, c, delta
		escreva("Esse programa determina a quantidade de raízes de uma equação do segundo grau!\n")
		escreva("Informe o valor do coeficiente 'a': ")
		leia(a)

		se(a == 0) {
			limpa()
			escreva("O coeficiente 'a' não pode ser zero! Tente novamente.")
		} senao {
			escreva("Informe o valor do coeficiente 'b': ")
			leia(b)

			escreva("Informe o valor do termo independente 'c': ")
			leia(c)
			limpa()

			delta = mat.potencia(b , 2.0) -4 * a * c

			se(delta < 0) {
				escreva("A equação não possui raízes reais, já que delta = ", delta)
			}

			se(delta == 0) {
				escreva("A equação possui uma raiz real, já que delta = ", delta)
			}

			se(delta > 0) {
				escreva("A equação possui duas raízes reais, já que delta = ", delta)
			}
 		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 404; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */