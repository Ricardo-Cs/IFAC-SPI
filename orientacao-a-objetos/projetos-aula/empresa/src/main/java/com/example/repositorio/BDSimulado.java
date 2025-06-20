package com.example.repositorio;

import java.util.HashMap;

import com.example.modelo.Departamento;
import com.example.modelo.Funcionario;


public class BDSimulado {
	
	private static HashMap<String, Departamento> departamentos = new HashMap<String, Departamento>();
	private static HashMap<String, Funcionario> funcionarios = new HashMap<String, Funcionario>();
	
	public static boolean addDepartamento(Departamento d) {
		if(departamentos.containsKey(d.getId())) return false; 
		departamentos.put(d.getId(), d);
		return true;
	}
	
	public static void removerDepartamento(String id) {
		departamentos.remove(id);
	}
	
	public static boolean addFuncionario(Funcionario f) {
		if(funcionarios.containsKey(f.getMatricula())) { //Verifica por matr�cula
			return false;
		}
		
		if(verificarFuncionario(f.getCpf())) { //Verifica se o cpf existe
			return false;
		}
		
		funcionarios.put(f.getMatricula(), f);
		return true;
	}
	
	public static void removerFuncionario(String matricula) {		
		funcionarios.remove(matricula); //Remove o funcion�rio do mapa de funcion�rios da empres
	}
	
	public static boolean verificarDepartamento(String id) {
		return departamentos.containsKey(id);
	}
	
	public static boolean verificarFuncionario(String cpf) {
		for(Funcionario f : funcionarios.values()) {
			if(f.getCpf().equals(cpf)) return true;
		}
		return false;
	}
	
	public static Departamento getDepartamento(String id) {
		return departamentos.get(id);
	}
	
	public static Funcionario getFuncionario(String matricula) {
		return funcionarios.get(matricula);
	}
	
	public static HashMap<String, Funcionario> getFuncionarios() {
		return funcionarios;
	}
}