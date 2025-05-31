package servico;

import modelo.Livro;
import modelo.Usuario;
import repositorio.BDSimulado;

public class ServicoUsuario {
	public void criarUsuario(String nome, String cpf, String email) {
		Usuario u = new Usuario(nome, cpf, email);
		if(BDSimulado.addUsuario(u)) {
			System.out.println("Usuário adicionado com sucesso!");
		}else {
			System.out.println("Usuário não pode ser adicionado!");
		}
	}
	
	public void listarUsuarios() {
		for(Usuario usuario: BDSimulado.getUsuarios().values()) {
			System.out.println("\n------Usuário Selecionado-------");
			System.out.println("Nome: " + usuario.getNome());
		    System.out.println("CPF: " + usuario.getCpf());
		    System.out.println("E-mail: " + usuario.getEmail());
		}
	}
}