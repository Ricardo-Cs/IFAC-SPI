package servico;

import java.time.LocalDate;

import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;
import repositorio.BDSimulado;

public class ServicoEmprestimo {
	public String emprestarLivro(Livro livro, Usuario usuario) {
		if(BDSimulado.emprestarLivro(livro, usuario)) {
			return "Livro Emprestado com Sucesso!";
		}
		return "Nao foi possivel emprestar esse livro!";
	}
	
	public String devolverLivro(Emprestimo emprestimo, String dataDevolucao) {
		BDSimulado.devolverLivro(emprestimo, LocalDate.parse(dataDevolucao));
		return "Livro devolvido com sucesso!";
	}
	
	
}
