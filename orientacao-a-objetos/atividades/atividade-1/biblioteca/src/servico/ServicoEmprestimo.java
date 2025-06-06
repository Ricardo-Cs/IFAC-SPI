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
	        s += "\nCódigo do empréstimo: " + codigoEmprestimo;
	        s += "\nTítulo: " + livro.getTitulo();
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
            return "\nNenhum empréstimo registrado no histórico.";
        }
        
        s += "\n--- HISTÓRICO DE EMPRÉSTIMOS ---";
        for (Emprestimo emprestimo : emprestimos.values()) {
            s += "\n------Empréstimo " + contadorEmprestimos + "-------";
            s += "\nID do Empréstimo: " + emprestimo.getId();
            s += "\nLivro: " + emprestimo.getLivroEmprestado().getTitulo();
            s += "\nUsuário: " + emprestimo.getUsuario().getNome();
            s += "\nCPF do Usuário: " + emprestimo.getUsuario().getCpf();
            s += "\nData do Empréstimo: " + emprestimo.getDataEmprestimo();
            s += "\nDevolvido: " + (emprestimo.isDevolvido() ? "Sim" : "Não");
            if(emprestimo.isDevolvido()) s += "\nData de Devolução: " + emprestimo.getDataDevolucao();
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
            return "\nNenhum livro disponível no momento.";
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
