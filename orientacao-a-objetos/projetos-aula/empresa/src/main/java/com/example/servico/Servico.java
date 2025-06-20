package com.example.servico;

import com.example.modelo.Departamento;
import com.example.modelo.Funcionario;
import com.example.repositorio.BDSimulado;

public class Servico {
	
	private Departamento d;
	private Funcionario f;
	
	public String cadastrarDepartamento(String nome, String id) {
		d = new Departamento(nome, id);
		if(BDSimulado.addDepartamento(d)) {
			return "Departamento cadastrado com sucesso!";
		}
		return "Este departamento j� est� cadastrado!";
	}
	
	public String removerDepartamento(String id) {
		if(BDSimulado.getDepartamento(id).getQuantidadeFuncionarios() == 0) {
			BDSimulado.removerDepartamento(id);
			return "Departamento removido com sucesso";
		}
		return "Um departamento com funcion�rios n�o pode ser exclu�do";
		
	}
	
	public String cadastrarFuncionario(String nome, String cpf, String idDepartamento) {
		if(!BDSimulado.verificarDepartamento(idDepartamento)) { 
			return "O departamento do cliente n�o existe!";
		}
		if(BDSimulado.verificarFuncionario(cpf)) {
			return "CPF j� cadastrado";
		}
		f = new Funcionario(nome, cpf, d);
		BDSimulado.getDepartamento(idDepartamento).adicionarFuncionario(f); //mudança feita para 4/6
		return "Funcion�rio cadastrado com sucesso";
	}
	
	public void removerFuncionario(String matricula) {
		Departamento d = BDSimulado.getFuncionario(matricula).getDepartamento();
		d.removerFuncionario(matricula);
		BDSimulado.removerFuncionario(matricula);
	}
	
	public String trasferirFuncionarioDepartamento(String matricula, String idOrigem, String idDestino) {
		if(!BDSimulado.verificarDepartamento(idDestino) || !BDSimulado.verificarDepartamento(idOrigem)) {
			return "Departamento de origem ou destino inexistente";
		}
		BDSimulado.getDepartamento(idOrigem).removerFuncionario(matricula);
		BDSimulado.getDepartamento(idDestino).adicionarFuncionario(BDSimulado.getFuncionario(matricula));
		BDSimulado.getFuncionario(matricula).setDepartamento(BDSimulado.getDepartamento(idDestino));
		return "Funcion�rio transferido com sucesso";
	}
	
	public String listarFuncionariosDepartamento(String id) {
		Departamento d = BDSimulado.getDepartamento(id);
		return d.listarFuncionarios();
		
	}
	
	public String listarFuncionarios() {
		String lista = "\nLista de funcionários: \n";
		for(Funcionario f : BDSimulado.getFuncionarios().values()) {
			lista += f.listarFuncionario() + "\n";
		}
		return lista;
	}
}