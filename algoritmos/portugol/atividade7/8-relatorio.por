programa
{
	
	funcao inicio()
	{
		inteiro opcao, contador = 0, verdeCastanho = 0, idade, idadeTotal = 0
		real altura, peso, pesoTotal = 0.0, masc = 0.0, fem = 0.0
		cadeia condicao = "s", caract, cor
		escreva("Esse programa fornece um relatório das características físicas de uma população!\n")
		
		 enquanto(condicao == "s" ou condicao == "sim") {
			contador++	
			escreva("Escolha o sexo da ", contador, "° pessoa\n")
			faca {
				escreva("1 - Masculino \n2 - Feminino\nOpção: ")
				leia(opcao)
				escolha(opcao) {
					caso 1: 
						masc++
						pare
					caso 2: 
						fem++
						pare
					caso contrario: 
						limpa()
						escreva("Valor inválido! Tente novamente.\n")
						
				}
			} enquanto(opcao != 1 e opcao != 2)

			limpa()
			escreva("Informe a cor dos olhos da ", contador, "° pessoa\n")
			faca {
				escreva("1 - Azuis \n2 - Verdes \n3 - Castanhos\nOpção: ")
				leia(opcao)

				escolha(opcao) {
					caso 1: 
						cor = "azuis"
						pare
					caso 2: 
						cor = "verdes"
						pare
					caso 3:
						cor = "castanhos"
						pare
					caso contrario: 
						limpa()
						cor = ""
						escreva("Valor inválido! Tente novamente.\n")
				}
			} enquanto(opcao != 1 e opcao != 2 e opcao != 3)

			limpa()
			escreva("Informe a cor dos cabelos da ", contador, "° pessoa\n")

			faca {
				escreva("1 - Louros \n2 - Castanhos \n3 - Pretos\nOpção: ")
				leia(opcao)

				escolha(opcao) {
					caso 1: 
						caract = "louros"
						pare
					caso 2: 
						caract = "castanhos"
						pare
					caso 3:
						caract = "pretos"
						pare
					caso contrario: 
						limpa()
						caract = ""
						escreva("Valor inválido! Tente novamente.\n")
				}
			} enquanto(opcao != 1 e opcao != 2 e opcao != 3)

			se(cor == "verdes" e caract == "castanhos") {
				verdeCastanho++
			}

			limpa()
			escreva("Informe a idade da ", contador, "° pessoa: ")
			leia(idade)
			idadeTotal = idadeTotal + idade

			escreva("Informe a altura da ", contador, "° pessoa: ")
			leia(altura)

			escreva("Informe o peso (em Kg) da ", contador, "° pessoa: ")
			leia(peso)
			pesoTotal = pesoTotal + peso
			
			escreva("Continuar a entrada de dados? s/n: ")
			leia(condicao)
			limpa()
		}

		escreva("\tRELATÓRIO \nMédia de idade: ", idadeTotal / contador)
		escreva("\nMédia de massa corporal: ", pesoTotal / contador) 
		escreva("\nPorcentagem de mulheres: ", (fem / contador) * 100 , "% \nPorcentagem de homens: ", (masc / contador) * 100, "%")
		escreva("\nPessoas com olhos verdes e cabelos castanhos: ", verdeCastanho)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1821; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */