package servico;

import modelo.Usuario;
import repositorio.BDSimulado;

public class ServicoUsuario {
	public String cadastrarUsuario(Usuario usuario) {
		if(BDSimulado.adicionarUsuario(usuario)) {
			return "Usuario adicionado com sucesso!";
		}
		return "Usuário não pode ser adicionado!";
	}
	
	public String listarUsuarios() {
		String s = "";
		for(Usuario usuario: BDSimulado.getUsuarios().values()) {
			s += "\n------Usuário-------";
			s += "\nNome: " + usuario.getNome();
		    s += "\nCPF: " + usuario.getCpf();
		    s += "\nE-mail: " + usuario.getEmail();
		    s += "\n";
		}
		return s;
	}
	
	public String consultarUsuario(String CPF) {
		Usuario usuarioConsultado = BDSimulado.selecionarUsuarioPorCPF(CPF);
		if(usuarioConsultado != null) {
			return "\nUsuario Encontrado!\n" + usuarioConsultado;
		}
		return "Usuario n�o encontrado!";
	}
	
	public void removerUsuario(String CPF) {
		BDSimulado.removerUsuario(CPF);
		System.out.println("\nUsuario removido com sucesso!");
	}
}