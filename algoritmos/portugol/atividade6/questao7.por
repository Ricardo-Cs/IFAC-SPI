programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		real peso, altura, imc
		escreva("Esse programa determina o IMC de uma pessoa e a classifica!\n")

		escreva("Informe seu peso em quilos: ")
		leia(peso)

		escreva("Informe sua altura em metros: ")
		leia(altura)
		limpa()

		imc = mat.arredondar(peso / (altura * altura), 1)

		se(imc < 16) {
			escreva("IMC = ", imc, "\nClassificação: Magreza grave")
		} senao se(imc >= 16 e imc < 17) {
			escreva("IMC = ", imc, "\nClassificação: Magreza moderada")
		} senao se(imc >= 17 e imc < 18.5) {
			escreva("IMC = ", imc, "\nClassificação: Magreza leve")
		} senao se(imc >= 18.5 e imc < 25) {
			escreva("IMC = ", imc, "\nClassificação: Saudável")
		} senao se(imc >= 25 e imc < 30) {
			escreva("IMC = ", imc, "\nClassificação: Sobrepeso")
		} senao se(imc >= 30 e imc < 35) {
			escreva("IMC = ", imc, "\nClassificação: Obesidade grau I")
		} senao se(imc >= 35 e imc < 40) {
			escreva("IMC = ", imc, "\nClassificação: Obesidade grau II (severa)")
		} senao se(imc >= 40) {
			escreva("IMC = ", imc, "\nClassificação: Obesidade grau III (mórbida)")
		} senao {
			escreva("Dados inválidos! Tente novamente.")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 532; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */