package servico;

import modelo.Usuario;
import repositorio.BDSimulado;

public class ServicoUsuario {
	public String cadastrarUsuario(Usuario usuario) {
		if(BDSimulado.adicionarUsuario(usuario)) {
			return "Usuario adicionado com sucesso!";
		}
		return "Usuario nao pode ser adicionado! CPF ja existente.";
	}

	public String listarUsuarios() {
		String s = "";
		int contadorUsuarios = 1;
		if (BDSimulado.getUsuarios().isEmpty()) {
            return "Nenhum usuario cadastrado.";
        }
		for(Usuario usuario: BDSimulado.getUsuarios().values()) {
			s += "\n------Usuario " + contadorUsuarios + "-------";
			s += "\nNome: " + usuario.getNome();
		    s += "\nCPF: " + usuario.getCpf();
		    s += "\nE-mail: " + usuario.getEmail();
		    s += "\n";
            contadorUsuarios++;
		}
		return s;
	}

	public String consultarUsuario(String CPF) {
		Usuario usuarioConsultado = BDSimulado.selecionarUsuarioPorCPF(CPF);
		if(usuarioConsultado != null) {
			return "\nUsuario Encontrado!\n" + usuarioConsultado;
		}
		return "Usuario nao encontrado!";
	}

	public void removerUsuario(String CPF) {
		BDSimulado.removerUsuario(CPF);
		System.out.println("\nUsuario removido com sucesso!");
	}
}