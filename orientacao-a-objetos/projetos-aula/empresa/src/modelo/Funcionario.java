package modelo;

public class Funcionario {
	private String matricula;
	private String nome;
	private String cpf;
	private double salario;
	private double bonificacao;
	private Departamento departamento;
	
	private static int contador = 0;
	
	
	public Funcionario(String nome, String cpf, Departamento departamento) {
		this.nome = nome;
		this.cpf = cpf;
		this.departamento = departamento;
		contador++;
		this.matricula = this.definirMatricula();
	}
	
	

	public Funcionario(String nome, String cpf, double salario, Departamento departamento) {
		this(nome, cpf, departamento);
		this.salario = salario;
	}


	
	private String definirMatricula() {
		String mat = Integer.toString(contador);
		while(mat.length()<3) mat = "0" + mat;
		String[] s = this.nome.split(" ");
		mat = s[s.length-1].charAt(0) + mat;
		mat = this.nome.charAt(0) + mat;
		return mat.toUpperCase();
	}

	public double bonificar() {
		this.bonificacao = salario*0.15;
		return this.bonificacao;
	}
	
	public boolean concederAumento(double salario) {
		if(salario > this.salario) {
			this.salario = salario;
			return true;
		} else return false;
	}
	
	public double getVencimentoMensal() {
		return this.salario + this.bonificacao;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public String getNome() {
		return nome;
	}
	
	@Override
	public String toString() {
		String relatorio = "\nNome: " + this.nome;
		relatorio += "\nMatr�cula: " + this.matricula;
		relatorio += "\nCPF: " + this.cpf;
		relatorio += "\nSal�rio: " + this.salario;
		relatorio += "\nVencimento mensal: " + this.getVencimentoMensal();
		return relatorio;
	}
}