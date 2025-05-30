package modelo;
import java.util.HashMap;

public class Departamento {
	private String nome;
	private String id;
	private HashMap<String, Funcionario> funcionarios;
	
	public Departamento(String nome, String id) {
		this.nome = nome;
		this.id = id;
	}
	
	public boolean adicionarFuncionario(Funcionario funcionario) {
		if(this.funcionarios.get(funcionario.getMatricula()) == null) {
			this.funcionarios.put(funcionario.getMatricula(), funcionario);
			return true;
		}
		return false;
	}
	
	public String getId() {
		return id;
	}
	
	public boolean removerFuncionario(String matricula) {
		if(this.funcionarios.containsKey(matricula)) {
			funcionarios.remove(matricula);
		}
		return false;
	}
	
	public String listarFuncionarios() {
		String lista = "\n";
		for(String m : this.funcionarios.keySet()) {
			lista += m + " - " + this.funcionarios.get(m).getNome() + "\n";
		}
		return lista;
	}
	
	public String emitirRelatorioUmFuncionario(String matriculaFuncionario) {
		if(this.funcionarios.containsKey(matriculaFuncionario)) {
			return "Este funcionário não pertence ao departamento " + this.nome;
		}
		
		return this.funcionarios.get(matriculaFuncionario).toString() + 
				"\nDepartamento " + this.nome;
	}
}