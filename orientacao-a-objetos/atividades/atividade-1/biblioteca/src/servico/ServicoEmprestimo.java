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
		return "Nao foi possivel emprestar esse livro! Verifique se ha exemplares disponiveis.";
	}

	public String devolverLivro(String emprestimoId, String dataDevolucaoString) {
	    try {
	        LocalDate dataDevolucao = LocalDate.parse(dataDevolucaoString);
	        if(BDSimulado.devolverLivro(emprestimoId, dataDevolucao)) {
	            return "Livro devolvido com sucesso!";
	        }
	        return "Nao foi possivel devolver o livro. Verifique o ID do emprestimo ou se ja foi devolvido.";
	    } catch (java.time.format.DateTimeParseException e) {
	        return "Formato de data invalido. Use YYYY-MM-DD.";
	    }
	}

	public String listarLivrosEmprestados() {
		String s = "";
		int contadorLivros = 1;
		for (Livro livro : BDSimulado.livrosEmprestados()) {
		    s += "\n------Livro " + contadorLivros + "-------";
		    s += "\nTítulo: " + livro.getTitulo();
		    s += "\nAutor: " + livro.getAutor();
		    s += "\nISBN: " + livro.getISBN();
		    s += "\nEditora: " + livro.getEditora();
		    s += "\nExemplares: " + livro.getQtdeExemplar();
		    s += "\n";
		    contadorLivros++;
		}
		if (contadorLivros == 1) { // If no books were added, it means the list was empty
            return "Nenhum livro atualmente emprestado.";
        }
		return s;
	}

    public String verificarLivrosDisponiveis() {
        String s = "";
        int contadorLivros = 1;
        var livrosDisponiveis = BDSimulado.livrosDisponiveis();
        if (livrosDisponiveis.isEmpty()) {
            return "Nenhum livro disponível no momento.";
        }
        s += "\n--- LIVROS DISPONÍVEIS NA BIBLIOTECA ---";
        for (Livro livro : livrosDisponiveis) {
            s += "\n------Livro " + contadorLivros + "-------";
            s += "\nTítulo: " + livro.getTitulo();
            s += "\nAutor: " + livro.getAutor();
            s += "\nISBN: " + livro.getISBN();
            s += "\nEditora: " + livro.getEditora();
            s += "\nExemplares Totais: " + livro.getQtdeExemplar();
            s += "\nExemplares Disponíveis: " + livro.getExemplaresDisponiveis();
            s += "\n";
            contadorLivros++;
        }
        return s;
    }
}