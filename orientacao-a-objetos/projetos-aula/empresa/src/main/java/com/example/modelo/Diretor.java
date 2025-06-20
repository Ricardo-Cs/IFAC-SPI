package com.example.modelo;

public class Diretor extends Gerente {

	public Diretor(String nome, String cpf, double salario, Departamento departamento) {
		super(nome, cpf, salario, departamento);
	}
	
	@Override
	public void bonificar() {
		super.bonificar();
		this.bonificacao += 1000.0;
	}
}