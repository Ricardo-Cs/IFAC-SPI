package servico;

import java.util.ArrayList;

import modelo.Livro;
import repositorio.BDSimulado;

public class ServicoLivro {
	
	public String criarLivro(String titulo, String autor, String ISBN, String editora, int qtdeExemplar) {
		Livro l = new Livro(titulo, autor, ISBN, editora, qtdeExemplar);
		if(BDSimulado.adicionarLivro(l)) {
			return "\nLivro adicionado com sucesso!";
		} else {
			return "\nLivro não pode ser adicionado!";
		}
	}

	public String listarLivros() {
		String s = "";
		for(Livro livro: BDSimulado.getLivros().values()) {
			s += "\n------Livro Selecinado-------";
			s += "TÃ­tulo: " + livro.getTitulo();
		    s += "Autor: " + livro.getAutor();
		    s += "ISBN: " + livro.getISBN();
		    s += "Editora: " + livro.getEditora();
		    s += "Exemplares: " + livro.getQtdeExemplar(); 
		}
		return s;
	}
	
	public String consultarLivro(String ISBN) {
		Livro livroConsultado = BDSimulado.selecionarLivroPorISBN(ISBN);
		if(livroConsultado != null) {
			return "\nLivro encontrado!\n" + livroConsultado;
		} else {
			return "\nLivro não encontrado!";
		}
	}
	
	public String consultarLivrosAutor(String autor) {
		ArrayList<Livro> livrosAutor = BDSimulado.selecionarLivroPorAutor(autor);
		if(!livrosAutor.isEmpty()) {
			String s = "\nLivros Encontrados!";
			for(Livro livro: livrosAutor) {
				s += "\n------Livro Selecinado-------";
				s += "TÃ­tulo: " + livro.getTitulo();
				s += "Autor: " + livro.getAutor();
			    s += "ISBN: " + livro.getISBN();
			    s += "Editora: " + livro.getEditora();
			    s += "Exemplares: " + livro.getQtdeExemplar();
			}
			return s;
		} else {
			return "Não existem livros do autor " + autor;
		}
	}
	
	public void removerLivro(String ISBN) {
		BDSimulado.removerLivro(ISBN);
		System.out.println("\nLivro removido com sucesso!");
	}
}