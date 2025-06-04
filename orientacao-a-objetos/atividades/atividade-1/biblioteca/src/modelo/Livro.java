package modelo;

public class Livro {
	private String titulo;
	private String autor;
	private String ISBN;
	private int ano;
	private String editora;
	private int qtdeExemplar;
	private int exemplaresDisponiveis;

	public Livro(String titulo, String autor, String ISBN, int ano, String editora, int qtdeExemplar) {
		this.titulo = titulo;
		this.autor = autor;
		this.ISBN = ISBN;
		this.ano = ano;
		this.editora = editora;
		this.qtdeExemplar = qtdeExemplar;
		this.exemplaresDisponiveis = qtdeExemplar;
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

    public int getExemplaresDisponiveis() {
        return exemplaresDisponiveis;
    }

    public boolean emprestarExemplar() {
        if (exemplaresDisponiveis > 0) {
            exemplaresDisponiveis--;
            return true;
        }
        return false;
    }

    public void devolverExemplar() {
        if (exemplaresDisponiveis < qtdeExemplar) {
            exemplaresDisponiveis++;
        }
    }

	@Override
	public String toString() {
		String s = "\nLivro: " + this.titulo;
		s += "\nAutor: " + this.autor;
		s += "\nISBN: " + this.ISBN;
		s += "\nEditoria: " + this.editora;
		s += "\nQuantidade de Exemplares: " + this.qtdeExemplar;
		s += "\nExemplares Disponíveis: " + this.exemplaresDisponiveis;
		return s;
	}
}
