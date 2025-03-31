programa
{
	inclua biblioteca Texto --> txt
	
	funcao inicio()
	{
		cadeia palavra = ""
		escreva("Esse programa substitui todas as vogais de uma palavra por 'X'\n")

		enquanto(palavra != "0") {
			escreva("Informe sua palavra: ")
			leia(palavra)			
			limpa()

			se(palavra != "0") {
				cadeia palavra2 = ""
				para(inteiro i = 0; i < txt.numero_caracteres(palavra); i++) {
					caracter char = txt.obter_caracter(palavra, i)
					se(char == 'a' ou char == 'e' ou char == 'i' ou char == 'o' ou char == 'u' ou
					   char == 'A' ou char == 'E' ou char == 'I' ou char == 'O' ou char == 'U') {
						palavra2 = palavra2 + "x"
					} senao {
						palavra2 = palavra2 + char
					}
					
				}
				escreva(palavra2, "\n")
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
 * @POSICAO-CURSOR = 727; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */