package modelo;
public class Cliente {
	private String nome;
	private String cpf;
	private String endereco;
	private String dataNascimento;
	
	// Construtor
	public Cliente(String nome, String cpf, String dataNascimento) {
		this.nome = nome;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
	}
		
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public String toString() {
		String relatorio = "Nome: " + this.nome;
		relatorio += "\nCPF: " + this.cpf;
		relatorio += "\nEndereço: " + this.endereco;
		relatorio += "\nData de Nascimento: " + this.dataNascimento;
		return relatorio;
	}
}
