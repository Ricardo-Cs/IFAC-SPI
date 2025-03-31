programa
{
	
	funcao inicio()
	{
		inteiro vetor[50]
		escreva("Esse programa imprime um vetor de tamanho 50!\n")

		para(inteiro i = 0; i < 50; i++) {
			vetor[i] = (i + 5 * i)%(i + 1)
		}

		para(inteiro i = 0; i < 50; i++) {
			escreva(vetor[i], " ")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 116; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */