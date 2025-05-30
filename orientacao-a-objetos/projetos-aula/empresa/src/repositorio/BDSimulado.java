package repositorio;

import java.util.HashMap;

import modelo.Departamento;
import modelo.Funcionario;

public class BDSimulado {
	private static HashMap<String, Departamento> departamentos = new HashMap<String, Departamento>();
	private static HashMap<String, Funcionario> funcionarios = new HashMap<String, Funcionario>();
	
	public static HashMap<String, Departamento> getDepartamentos() {
		return departamentos;
	}
	
	public static HashMap<String, Funcionario> getFuncionarios() {
		return funcionarios;
	}
	
	public boolean addDepartamento(Departamento departamento) {
		String id = departamento.getId();
		if(departamentos.containsKey(id)) {
			return false;
		}
		departamentos.put(id, departamento);
		return true;
	}
	
	// Outros métodos
	public boolean addFuncionario(Funcionario f) {
		String mat = f.getMatricula();
		if(funcionarios.containsValue(mat)) {
			return false;
		}
		funcionarios.put(mat, f);
		return true;
	}
}
