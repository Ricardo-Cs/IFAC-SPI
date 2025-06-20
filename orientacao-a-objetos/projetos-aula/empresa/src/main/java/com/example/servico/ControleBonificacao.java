package com.example.servico;

import com.example.modelo.Funcionario;

public class ControleBonificacao {
	private static double totalBonficacao = 0;
	
	public static double registrarBonficacao(Funcionario f) {
		f.bonificar();
		totalBonficacao += f.getBonificacao();
		return f.getBonificacao();
	}
	
	public static double getTotalBonficacao() {
		return totalBonficacao;
	}

}