programa
{
	inclua biblioteca Texto --> txt
	
	funcao inicio()
	{	
		cadeia texto = ""
		escreva("Esse programa mostra a quantidade de vogais de um texto!\n")
		
		enquanto(texto != "0") {
			inteiro vogal = 0
			escreva("Informe o texto (digite 0 para fechar): ")
			leia(texto)

			se(texto != "0") {
				texto = txt.caixa_alta(texto)
	
				para(inteiro i = 0; i < txt.numero_caracteres(texto); i++){
					caracter char = txt.obter_caracter(texto, i)
					se(char == 'A' ou char == 'E' ou char == 'I' ou char == 'O' ou char == 'U') {
						vogal++
					}
				}
				escreva("A quantidade de vogais do texto é: ", vogal, "\n")
			} senao {
				limpa()
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
 * @POSICAO-CURSOR = 651; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */