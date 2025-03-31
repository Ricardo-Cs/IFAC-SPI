programa
{
	inclua biblioteca Texto --> txt
	
	funcao inicio()
	{
		cadeia texto 
		inteiro maior = -1, menor = 999999, caracteres, n
		real media = 0.0
		escreva("Esse programa mostra a média de caracteres e tamanho do maior e menor texto de n textos!\n")
		escreva("Informe a quantidade de textos: ")
		leia(n)
		limpa()
		
		para(inteiro i = 1; i <= n; i++) {
			escreva("Escreva o ", i, "° texto: ")
			leia(texto)
			
			caracteres = txt.numero_caracteres(texto)
			media = media + caracteres

			se(caracteres > maior) {
				maior = caracteres
			} senao se (caracteres < menor) {
				menor = caracteres
			}
			limpa()
		}

		limpa()
		escreva("Média do número de caracteres: ", media / n)
		escreva("\nTamanho do maior texto: ", maior)
		escreva("\nTamanho do menor texto: ", menor)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 695; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */