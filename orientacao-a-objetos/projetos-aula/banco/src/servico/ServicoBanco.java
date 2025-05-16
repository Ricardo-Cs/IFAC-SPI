package servico;

import modelo.Cliente;
import repositorio.BDsimulado;

public class ServicoBanco {
	
	public void criarConta() {
		
	}
	
	public void criarCliente(String nome, String cpf, String dataNascimento) {
		Cliente c = new Cliente(nome, cpf, dataNascimento);
		BDsimulado.getClientes().put(cpf, c);
	}
	
	public void criarCliente(String nome, String cpf, String endereco, String dataNascimento) {
		Cliente c = new Cliente(nome, cpf, endereco, dataNascimento);
		BDsimulado.getClientes().put(cpf, c);
	}
}
