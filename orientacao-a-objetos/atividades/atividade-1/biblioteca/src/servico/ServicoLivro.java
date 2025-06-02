package servico;

import java.util.ArrayList;

import modelo.Livro;
import repositorio.BDSimulado;

public class ServicoLivro {
	
	public String cadastrarLivro(Livro livro) {
		if(BDSimulado.adicionarLivro(livro)) {
			return "\nLivro adicionado com sucesso!";
		}
		return "\nLivro nao pode ser adicionado!";
	}

	public String listarLivros() {
		String s = "";
		int contadorLivros = 1;
		for (Livro livro : BDSimulado.getLivros().values()) {
		    s += "\n------Livro " + contadorLivros + "-------";
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
	
	public String consultarLivro(String ISBN) {
		Livro livroConsultado = BDSimulado.selecionarLivroPorISBN(ISBN);
		if(livroConsultado != null) {
			return "\nLivro encontrado!\n" + livroConsultado;
		}
		return "\nLivro n�o encontrado!";
	}
	
	public String consultarLivrosAutor(String autor) {
		ArrayList<Livro> livrosAutor = BDSimulado.selecionarLivroPorAutor(autor);
		int contadorLivros = 1;
		if(!livrosAutor.isEmpty()) {
			String s = "\nLivros Encontrados!";
			for(Livro livro: livrosAutor) {
				s += "\n------Livro " + contadorLivros + "-------";
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
		return "\nNao existem livros do autor " + autor + "\n";
	}
	
	public void removerLivro(String ISBN) {
		BDSimulado.removerLivro(ISBN);
		System.out.println("\nLivro removido com sucesso!");
	}
}