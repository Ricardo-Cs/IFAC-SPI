programa
{
	
	funcao inicio()
	{
		inteiro matricula[3], notas[3]
		caracter dados[3][10], gabarito[10] = { 'a', 'a', 'd', 'b', 'c', 'c', 'b', 'e', 'e', 'b' }
		real aprovacao = 0.0
		escreva("Esse programa corrige uma prova e retorna os dados da mesma!\n")

		para(inteiro i = 0; i < 3; i++) {
			inteiro nota = 0
			escreva("Informe a matrícula do ", i + 1, "° aluno: ")
			leia(matricula[i])
			para(inteiro j = 0; j < 10; j++) {
				escreva("Informe a resposta da questão ", j + 1, ": ")
				caracter char
				leia(char)
				dados[i][j] = char
				
				se(char != 'a' e char != 'b' e char != 'c' e char != 'd' e char != 'e') {
					escreva("Resposta inválida! Tente novamente.\n")
					j--
				} senao {
					se(char == gabarito[j]) {
						nota++
					}
				}
			}
			notas[i] = nota
			limpa()
		}
		
		limpa()
		escreva("\tDados dos alunos: \n")
		escreva("Gabarito: [ ")
		para(inteiro i = 0; i < 10; i++) escreva(gabarito[i], " ")
		escreva("]\n\n")
		para(inteiro i = 0; i < 3; i++) {
			escreva("Aluno ", i + 1, "\n")
			escreva("Matrícula: ", matricula[i], "\n")
			escreva("Respostas: [ ")
			para(inteiro j = 0; j < 10; j++) {
				escreva(dados[i][j], " ")
			}
			escreva("]")
			escreva("\nNota: ", notas[i], "\n\n")
		}
		escreva("Percentual de aprovação: ")
		para(inteiro i = 0; i < 3; i++) {
			se(notas[i] >= 7) {
				aprovacao++
			}
		}
		escreva((aprovacao / 3) * 100, "%")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 484; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */