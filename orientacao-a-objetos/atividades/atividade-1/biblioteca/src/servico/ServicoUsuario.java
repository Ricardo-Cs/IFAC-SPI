package servico;

import modelo.Usuario;
import repositorio.BDSimulado;

public class ServicoUsuario {
	public String criarUsuario(String nome, String cpf, String email) {
		Usuario u = new Usuario(nome, cpf, email);
		if(BDSimulado.adicionarUsuario(u)) {
			return "Usuario adicionado com sucesso!";
		} else {
			return "Usuário não pode ser adicionado!";
		}
	}
	
	public String listarUsuarios() {
		String s = "";
		for(Usuario usuario: BDSimulado.getUsuarios().values()) {
			s += "\n------Usuário Selecionado-------";
			s += "Nome: " + usuario.getNome();
		    s += "CPF: " + usuario.getCpf();
		    s += "E-mail: " + usuario.getEmail();
		}
		return s;
	}
	
	public String consultarUsuario(String CPF) {
		Usuario usuarioConsultado = BDSimulado.selecionarUsuarioPorCPF(CPF);
		if(usuarioConsultado != null) {
			return "\nUsuario Encontrado!\n" + usuarioConsultado;
		} else {
			return "Usuario n�o encontrado!";
		}
	}
	
	public void removerUsuario(String CPF) {
		BDSimulado.removerUsuario(CPF);
		System.out.println("\nUsuario removido com sucesso!");
	}
}