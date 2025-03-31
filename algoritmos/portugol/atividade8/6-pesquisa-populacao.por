programa
{
	inclua biblioteca Texto --> txt
	
	funcao inicio()
	{
		inteiro n = 1, caracteres = 0, tam_atual, tam_maior = 0, tam_menor = 99999999, vogais = 0, nomesEspecificos = 0
		cadeia nomeAtual, condicao, maior = "", menor = ""
		escreva("Esse programa recebe dados de uma pesquisa dos nomes completos uma população e retorna as estatísticas!\n")
		
		faca {
			escreva("Informe o ", n, "° nome: ")
			leia(nomeAtual)
			nomeAtual = txt.caixa_baixa(nomeAtual)
			tam_atual = txt.numero_caracteres(nomeAtual)
			caracteres = caracteres + tam_atual
			
			se(tam_atual > tam_maior) {
				tam_maior = tam_atual
				maior = nomeAtual
			} 
			se(tam_atual < tam_menor) {
				tam_menor = tam_atual
				menor = nomeAtual
			}
			
			para(inteiro i = 0; i < txt.numero_caracteres(nomeAtual); i++) {
				caracter char = txt.obter_caracter(nomeAtual, i)
				se(char == 'a' ou char == 'e' ou char == 'i' ou char == 'o' ou char == 'u') {
					vogais++
				}
			}

			// Verifica se tem 'Maria', 'Paulo' ou 'Luiza' no texto, independente da posição.
			inteiro maria = txt.posicao_texto("maria", nomeAtual, 0)
			inteiro paulo = txt.posicao_texto("paulo", nomeAtual, 0)
			inteiro luiza = txt.posicao_texto("luiza", nomeAtual, 0)

			se(maria != -1 ou paulo != -1 ou luiza != -1) {
				nomesEspecificos++
			}

			escreva("Deseja continuar a inserção de dados? (s/n): ")
			leia(condicao)
			txt.caixa_baixa(condicao)
			limpa()
			n++
		} enquanto(condicao == "s" ou condicao == "sim")

		escreva("\tRelatório\nQuantidade de nomes informados: ", n - 1)
		escreva("\nQuantidade total de caracteres dos nomes: ", caracteres)
		escreva("\nMaior nome: ", maior)
		escreva("\nTamanho do maior nome: ", tam_maior)
		escreva("\nMenor nome: ", menor)
		escreva("\nTamanho do menor nome: ", tam_menor)
		escreva("\nMédia do tamanho dos nomes: ", caracteres / (n - 1))
		escreva("\nNúmero de vogais: ", vogais)
		escreva("\nQuantidade de nomes 'Maria', 'Paulo' e 'Luiza': ", nomesEspecificos)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1981; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */