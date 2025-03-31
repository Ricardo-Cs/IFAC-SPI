programa
{
	
	funcao inicio()
	{
		inteiro vetor[6], soma = 0, qtdImpares = 0, pares[6], impares[6]
		escreva("Esse programa mostra alguns dados de um vetor!\n")

		para(inteiro i = 0; i < 6; i++) {
			escreva("Informe o ", i + 1, "° número: ")
			leia(vetor[i])
			se(vetor[i] % 2 == 0) {
				soma += vetor[i]
			} senao {
				qtdImpares++
			}
			limpa()
		}

		para(inteiro i = 0; i < 6; i++) {
			se(vetor[i] % 2 == 0) {
				para(inteiro j = 0; j < 6; j++) {
					se(pares[j] == 0) {
						pares[j] = vetor[i]
						pare
					}
				}
			} senao {
				para(inteiro j = 0; j < 6; j++) {
					se(impares[j] == 0) {
						impares[j] = vetor[i]
						pare
					}
				}
			}
		}
		escreva("Pares: ")
		para(inteiro i = 0; i < 6; i++) {
			se(pares[i] != 0) {
				escreva(pares[i], " ")
			}
		}
		escreva("\nSoma dos pares: ", soma)
		escreva("\nÍmpares: ")
		para(inteiro i = 0; i < 6; i++) {
			se(impares[i] != 0) {
				escreva(impares[i], " ")
			}
		}
		escreva("\nQuantidade de ímpares: ", qtdImpares)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 693; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */