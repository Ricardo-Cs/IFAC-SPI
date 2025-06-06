package servico;

import java.time.LocalDate;
import java.util.HashMap;

import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;
import repositorio.BDSimulado;

public class ServicoEmprestimo {
	public String emprestarLivro(Livro livro, Usuario usuario) {
		if(BDSimulado.emprestarLivro(livro, usuario)) {
			return "\nLivro Emprestado com Sucesso!";
		}
		return "\nNao foi possivel emprestar esse livro! Verifique se ha exemplares disponiveis.";
	}

	public String devolverLivro(String emprestimoId, String dataDevolucaoString) {
	    try {
	        LocalDate dataDevolucao = LocalDate.parse(dataDevolucaoString);
	        if(BDSimulado.devolverLivro(emprestimoId, dataDevolucao)) {
	            return "Livro devolvido com sucesso!";
	        }
	        return "\nNao foi possivel devolver o livro. Verifique o ID do emprestimo ou se ja foi devolvido.";
	    } catch (java.time.format.DateTimeParseException e) {
	        return "\nFormato de data invalido. Use YYYY-MM-DD.";
	    }
	}

	public String listarLivrosEmprestados() {
	    String s = "";
	    int contadorLivros = 1;

	    HashMap<String, Livro> livrosEmprestadosMap = BDSimulado.livrosEmprestados();

	    if (livrosEmprestadosMap.isEmpty()) {
	        return "\nNenhum livro atualmente emprestado.";
	    }

	    for (HashMap.Entry<String, Livro> valor : livrosEmprestadosMap.entrySet()) {
	        String codigoEmprestimo = valor.getKey();
	        Livro livro = valor.getValue();       

	        s += "\n------Livro " + contadorLivros + "-------";
	        s += "\nC�digo do empr�stimo: " + codigoEmprestimo;
	        s += "\nT�tulo: " + livro.getTitulo();
	        s += "\nAutor: " + livro.getAutor();
	        s += "\nISBN: " + livro.getISBN();
	        s += "\nEditora: " + livro.getEditora();
	        s += "\nExemplares: " + livro.getQtdeExemplar();
	        s += "\n";
	        contadorLivros++;
	    }

	    return s;
	}
	
    public String listarHistoricoEmprestimos() {
        String s = "";
        int contadorEmprestimos = 1;
        
        HashMap<String, Emprestimo> emprestimos = BDSimulado.getEmprestimos();
        
        if (emprestimos.isEmpty()) {
            return "\nNenhum empr�stimo registrado no hist�rico.";
        }
        
        s += "\n--- HIST�RICO DE EMPR�STIMOS ---";
        for (Emprestimo emprestimo : emprestimos.values()) {
            s += "\n------Empr�stimo " + contadorEmprestimos + "-------";
            s += "\nID do Empr�stimo: " + emprestimo.getId();
            s += "\nLivro: " + emprestimo.getLivroEmprestado().getTitulo();
            s += "\nUsu�rio: " + emprestimo.getUsuario().getNome();
            s += "\nCPF do Usu�rio: " + emprestimo.getUsuario().getCpf();
            s += "\nData do Empr�stimo: " + emprestimo.getDataEmprestimo();
            s += "\nDevolvido: " + (emprestimo.isDevolvido() ? "Sim" : "N�o");
            if(emprestimo.isDevolvido()) s += "\nData de Devolu��o: " + emprestimo.getDataDevolucao();
            s += "\n";
            contadorEmprestimos++;
        }
        
        return s;
    }

    public String verificarLivrosDisponiveis() {
        String s = "";
        int contadorLivros = 1;
        var livrosDisponiveis = BDSimulado.livrosDisponiveis();
        if (livrosDisponiveis.isEmpty()) {
            return "\nNenhum livro dispon�vel no momento.";
        }
        s += "\n--- LIVROS DISPON�VEIS NA BIBLIOTECA ---";
        for (Livro livro : livrosDisponiveis) {
            s += "\n------Livro " + contadorLivros + "-------";
            s += "\nT�tulo: " + livro.getTitulo();
            s += "\nAutor: " + livro.getAutor();
            s += "\nISBN: " + livro.getISBN();
            s += "\nEditora: " + livro.getEditora();
            s += "\nExemplares Totais: " + livro.getQtdeExemplar();
            s += "\nExemplares Dispon�veis: " + livro.getExemplaresDisponiveis();
            s += "\n";
            contadorLivros++;
        }
        return s;
    }
}
