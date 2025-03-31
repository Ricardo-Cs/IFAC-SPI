programa
{
	inclua biblioteca Util
	
	funcao inicio()
	{
		inteiro vetor[10], valor, posicao = 0
		logico verifica = falso
		escreva("Esse programa verifica se um valor existe em um vetor!\n")

		para(inteiro i = 0; i < 10; i++) {
			vetor[i] = Util.sorteia(0, 100)
		}

		escreva("Informe o número que deseja verificar: ")
		leia(valor)
		limpa()
		para(inteiro i = 0; i < 10; i++) {
			se(vetor[i] == valor) {
				verifica = verdadeiro
				posicao = i
				pare
			} senao {
				verifica = falso
			}
		}

		escreva("Vetor sorteado: [ ")
		para(inteiro i = 0; i < 10; i++) {
			escreva(vetor[i], " ")
		}
		escreva("]\n")

		se(verifica == verdadeiro) {
			escreva("O valor ", valor, " existe no vetor! Na posição ", posicao)
		} senao {
			escreva("O valor ", valor, " não existe no vetor!")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 802; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */