package modelo;

public class Livro {
	private String titulo;
	private String autor;
	private String ISBN;
	private String editora;
	private int qtdeExemplar;
	
	public Livro(String titulo, String autor, String ISBN, String editora, int qtdeExemplar) {
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = ISBN;
		this.editora = editora;
		this.qtdeExemplar = qtdeExemplar;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getAutor() {
		return autor;
	}

	public String getISBN() {
		return ISBN;
	}

	public String getEditora() {
		return editora;
	}

	public int getQtdeExemplar() {
		return qtdeExemplar;
	} 
	
	@Override
	public String toString() {
		String s = "\nLivro: " + this.titulo;
		s += "\nAutor: " + this.autor;
		s += "\nISBN: " + this.ISBN;
		s += "\nEditoria: " + this.editora;
		s += "\nQuantidade de Exemplares: " + this.qtdeExemplar;
		
		return s;
	}
}
