programa
{
	inclua biblioteca Texto --> txt
	
	funcao inicio()
	{
		cadeia texto, posicao_a = "", posicao_e = "", posicao_i = "", posicao_o = "", posicao_u = ""
		escreva("Esse programa mostra a posição das vogais em um texto\n")
		escreva("Informe o texto: ")
		leia(texto)
		texto = txt.caixa_baixa(texto)
		
		para(inteiro i = 0; i < txt.numero_caracteres(texto); i++) {
			caracter char = txt.obter_caracter(texto, i)

			se(char == 'a') {
				posicao_a = posicao_a + i + " "
			} senao se(char == 'e') {
				posicao_e = posicao_e + i + " "
			} senao se(char == 'i') {
				posicao_i = posicao_i + i + " "
			} senao se(char == 'o') {
				posicao_o = posicao_o + i + " "
			} senao se(char == 'u') {
				posicao_u = posicao_u + i + " "
			}
		}
		limpa()

		escreva("\tPosições\n", "A: ", posicao_a, "\n")
		escreva("E: ", posicao_e, "\n")
		escreva("I: ", posicao_i, "\n")
		escreva("O: ", posicao_o, "\n")
		escreva("U: ", posicao_u, "\n")
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 285; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */