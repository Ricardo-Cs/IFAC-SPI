package servico;

import modelo.Livro;
import repositorio.BDSimulado;

public class ServicoLivro {
	
	public void criarLivro(String titulo, String autor, String ISBN, String editora, int qtdeExemplar) {
		Livro l = new Livro(titulo, autor, ISBN, editora, qtdeExemplar);
		if(BDSimulado.addLivro(l)) {
			System.out.println("\nLivro adicionado com sucesso!");
		}else {
			System.out.println("\nLivro não pode ser adicionado!");
		}
	}

	public void listarLivros() {
		for(Livro livro: BDSimulado.getLivros().values()) {
			System.out.println("\n------Livro Selecinado-------");
			System.out.println("Título: " + livro.getTitulo());
		    System.out.println("Autor: " + livro.getAutor());
		    System.out.println("ISBN: " + livro.getISBN());
		    System.out.println("Editora: " + livro.getEditora());
		    System.out.println("Exemplares: " + livro.getQtdeExemplar());
		}
	}
	
	public void consultarLivro(String ISBN) {
		if(BDSimulado.selecionarCODlivro(ISBN)) {
			System.out.println("\nLivro encontrado!");
			System.out.println(BDSimulado.getLivros().get(ISBN));
		}else {
			System.out.println("\nLivro não encontrado!");
		}
	}
	
	public void consultarLivrosAutor(String autor) {
		for(Livro livro: BDSimulado.getLivros().values()) {
			if(livro.getAutor() == autor) {
				System.out.println("\n------Livro Selecinado-------");
				System.out.println("Título: " + livro.getTitulo());
			    System.out.println("Autor: " + livro.getAutor());
			    System.out.println("ISBN: " + livro.getISBN());
			    System.out.println("Editora: " + livro.getEditora());
			    System.out.println("Exemplares: " + livro.getQtdeExemplar());
			}
		}
	}
	
	public void removerLivro(String ISBN) {
		BDSimulado.removerLivro(ISBN);
		System.out.println("\nLivro removido com sucesso!");
	}
}