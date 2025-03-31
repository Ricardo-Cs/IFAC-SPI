programa
{
	
	funcao inicio()
	{
		real vetor[10], soma = 0.0
		escreva("Esse programa calcula a soma de um vetor com recursividade!\n")
	
		para(inteiro i = 0; i < 10; i++) {
			escreva("Informe o valor na ", i + 1, "° posição: ")
			leia(vetor[i])
			limpa()
		}
		escreva("Soma: ", soma_vetor(10, vetor))
	}

	funcao real soma_vetor(inteiro posicao, real &vetor[]) {
		se(posicao == 0) {
			retorne 0.0
		} senao {
			retorne vetor[posicao-1] + soma_vetor(posicao - 1, vetor)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 310; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */