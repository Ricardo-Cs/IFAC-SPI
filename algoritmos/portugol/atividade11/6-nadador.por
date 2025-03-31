programa
{
	
	funcao inicio()
	{	
		inteiro idade
		cadeia categoria
		escreva("Esse programa diz a categoria de um nadador com base na sua idade!\n")
		escreva("Informe a idade do nadador: ")
		leia(idade)
		limpa()
		se(idade < 5) escreva("Idade inválida! Tente novamente.")
		senao {
			categoria = categoria_nadador(idade)
			escreva("O nadador pertence a categoria ", categoria)
		}
	}

	funcao cadeia categoria_nadador(inteiro idade) {
		se(idade >= 5 e idade <= 7) retorne "Infantil A"
		senao se(idade >= 8 e idade <= 10) retorne "Infantil B"
		senao se(idade >= 11 e idade <= 13) retorne "Juvenil A"
		senao se(idade >= 14 e idade <= 17) retorne "Juvenil B"
		senao retorne "Adulto"
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 383; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */