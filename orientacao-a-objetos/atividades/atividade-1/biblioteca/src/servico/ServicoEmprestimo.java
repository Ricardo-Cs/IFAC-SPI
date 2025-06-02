package servico;

import modelo.Livro;
import modelo.Usuario;
import repositorio.BDSimulado;

public class ServicoEmprestimo {
	public String emprestarLivro(Livro livro, Usuario usuario) {
		if(BDSimulado.emprestarLivro(livro, usuario)) {
			return "Livro Emprestado com Sucesso!";
		}
		return "Não foi possível emprestar esse livro!";
	}
}
