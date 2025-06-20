package com.example.modelo;

public class Gerente extends Funcionario {

	private int numeroFuncionariosGerenciados;
	private String senha;
	
	public Gerente(String nome, String cpf, Departamento departamento ) {
		super(nome, cpf, departamento);
		this.numeroFuncionariosGerenciados = 0;
	}
	
	public Gerente(String nome, String cpf, double salario, Departamento departamento ) {
		super(nome, cpf, salario, departamento);
		this.numeroFuncionariosGerenciados = 0;
	}
	
	public boolean autenticar(String senha) {
		return this.senha.equals(senha);
	}
	
	public void setNumeroFuncionariosGerenciados(int numeroFuncionariosGerenciados) {
		this.numeroFuncionariosGerenciados = numeroFuncionariosGerenciados;
	}
	
	@Override
	public void bonificar() {
		this.bonificacao = this.salario*0.25;
	}
}