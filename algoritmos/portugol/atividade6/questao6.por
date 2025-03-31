programa
{
	inclua biblioteca Internet --> inter
	inclua biblioteca Texto --> tex
	
	funcao inicio()
	{
		cadeia pais
		escreva("Esse programa determina se um país é sulamericano ou não!\n")
		
		escreva("Informe o código do país (ex.: BRA): ")
		leia(pais)
		limpa()

		pais = tex.caixa_alta(pais)

		se(pais == "ARG" ou pais == "BOL" ou pais == "BRA" ou pais == "CHI" ou pais == "COL" ou pais == "ECU" ou pais == "GUY" ou pais == "PAR" ou pais == "BOL" ou pais == "PER" 
			ou pais == "SUR" ou pais == "URU" ou pais == "VEN") {
			escreva("O país é sulamericano!")
		} senao {
			escreva("O país não é sulamericano!")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 624; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */