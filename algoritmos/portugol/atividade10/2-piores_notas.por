programa
{
	
	funcao inicio()
	{
		inteiro p1 = 0, p2 = 0, p3 = 0
		real notas[10][3]
		escreva("Esse programa mostra em quais provas 10 alunos tiveram a pior nota!\n")
		para(inteiro i = 0; i < 10; i++) {
			escreva("Aluno ", i + 1, "\n")
			para(inteiro j = 0; j < 3; j++) {
				escreva("Informe a ", j + 1, "° nota: ")
				leia(notas[i][j])
			}
			limpa()
		}

		para(inteiro i = 0; i < 10; i ++) {
			real nota1 = notas[i][0], nota2 = notas[i][1], nota3 = notas[i][2]
			se(nota1 < nota2 e nota1 < nota3) p1++
			senao se(nota2 < nota1 e nota2 < nota3) p2++
			senao se(nota3 < nota1 e nota3 < nota2) p3++
			senao {
				se(nota1 == nota2 ou nota1 == nota3) p1++
				senao p2++
			}
		}

		escreva("\tPiores notas dos alunos\n")
		escreva("Prova 1: ", p1, "\n")
		escreva("Prova 2: ", p2, "\n")
		escreva("Prova 3: ", p3, "\n")
	}
}


/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 682; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = {notas, 7, 7, 5};
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */