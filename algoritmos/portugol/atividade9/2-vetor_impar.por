programa
{
	
	funcao inicio()
	{
		inteiro vetor[10], impares[10]
		escreva("Esse programa imprime os valores ímpares de um vetor!\n")
	
		para(inteiro i = 0; i < 10; i++) {
			escreva("Informe o valor na ", i + 1, "° posição: ")
			leia(vetor[i])
			se(vetor[i] % 2 != 0) {
				para(inteiro j = 0; j < 10; j++) {
					// Se o elemento no vetor for igual a zero, ou seja, vazio, insere o valor lido
					se(impares[j] == 0) {
						impares[j] = vetor[i]
						pare	
					}
				}
			}
		}
		
		limpa()
		escreva("Os números ímpares são: [ ")
		para(inteiro i = 0; i < 10; i++) {
			se(impares[i] != 0) {
				escreva(impares[i], " ")
			}
		}
		escreva("]")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 280; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */