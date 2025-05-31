package modelo;

public class Usuario {
	private String nome;
	private String cpf;
	private String email;
	
	
	public Usuario(String nome, String cpf, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
	}


	public String getNome() {
		return nome;
	}


	public String getCpf() {
		return cpf;
	}


	public String getEmail() {
		return email;
	}


	@Override
	public String toString() {
		String s = "\nNome: " + this.nome;
		s += "\nCPF: " + this.cpf;
		s += "\nE-mail: " + this.email;
		return s;
	}
	
	
	
	
	
}
