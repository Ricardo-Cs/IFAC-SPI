package aplicacao;

import modelo.Departamento;
import modelo.Funcionario;

public class Aplicacao {

	public static void main(String[] args) {
		Funcionario f = new Funcionario("Joao da Silva de Paula", "12345678900", new Departamento("Tecnologia da Informação", "TI"));
		Funcionario f1 = new Funcionario("Leonardo da Vinci", "12345678900", new Departamento("Tecnologia da Informação", "T2"));
		System.out.println(f.getMatricula());
		System.out.println(f1.getMatricula());
	}

}