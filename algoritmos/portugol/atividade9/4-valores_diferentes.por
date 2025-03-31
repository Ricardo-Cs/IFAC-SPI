programa
{
	
	funcao inicio()
	{
		inteiro vetor[10]
		escreva("Esse programa cria um vetor com valores diferentes!\n")

		para(inteiro i = 0; i < 10; i++) {
			inteiro valor
			logico igual = verdadeiro
			escreva("Informe o ", i + 1, "° valor: ")
			leia(valor)

			para(inteiro j = 0; j < 10; j++) {
				se(vetor[j] != valor) {
					igual = falso
				} senao {
					igual = verdadeiro
					pare
				}
			}

			se(igual == falso) {
				vetor[i] = valor
			} senao {
				escreva("O valor inserido já existe! Tente novamente\n")
				i--
			}
		}

		limpa()
		escreva("Vetor: [ ")
		para(inteiro i = 0; i < 10; i++) {
			escreva(vetor[i], " ")
		}
		escreva("]")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 552; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */