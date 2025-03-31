programa
{
	
	funcao inicio()
	{
		cadeia nomes[3]
		real notas[3][4], medias[3]
		escreva("Esse programa verifica a situação de um aluno!\n")

		para(inteiro i = 0; i < 3; i++) {
			real soma = 0.0
			escreva("Informe o nome do ", i + 1, "° aluno: ")
			leia(nomes[i])
			limpa()
			para(inteiro j = 0; j < 4; j++) {
				escreva("Informe a ", j + 1, "° nota: ")
				leia(notas[i][j])
				soma += notas[i][j]
			}
			calcula_media(soma, medias, i)
			limpa()
		}

		para(inteiro i = 0; i < 3; i++) {
			imprimir_relatorio(i, nomes, notas, medias)
		}

	}

	funcao calcula_media(real soma, real &media[], inteiro posicao) {
		media[posicao] = soma / 4
	}
	
	funcao imprimir_relatorio(inteiro aluno_num, cadeia nomes[], real notas[][], real medias[]) {
		separacao(50)
		escreva("\tRelatório do Aluno: ", nomes[aluno_num], "\n")
		separacao(50)
		escreva("Notas: ")
		para(inteiro i = 0; i < 4; i++) {
			escreva(notas[aluno_num][i], " ")
		}
		escreva("\nMédia: ", medias[aluno_num], "\n")
		situacao_aluno(medias[aluno_num])
		separacao(50)
		escreva("\n")
	}

	funcao situacao_aluno(real media) {
		se(media >= 7) {
			escreva("Situação: Aprovado\n")
		} senao {
			escreva("Situação: Reprovado\n")
		}
	}

	funcao separacao(inteiro tamanho) {
		para(inteiro i = 0; i < tamanho; i++) {
			escreva("-")
		}
		escreva("\n")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1040; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */