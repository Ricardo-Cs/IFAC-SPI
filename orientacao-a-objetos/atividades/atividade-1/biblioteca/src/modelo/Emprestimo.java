package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
	private static int contador = 1;
	private int id = contador;
	private Livro livroEmprestado;
	private Usuario usuario;
	private boolean devolvido = false;
	private LocalDate dataEmprestimo = LocalDate.now();
	private String dataDevolucao;
	
	public Emprestimo(Livro livroEmprestado, Usuario usuario) {
		this.livroEmprestado = livroEmprestado;
		this.usuario = usuario;
		contador++;
	}
	
	public Emprestimo(Livro livroEmprestado, Usuario usuario, LocalDate dataEmprestimo) {
		this(livroEmprestado, usuario);
		this.dataEmprestimo = dataEmprestimo;
	}

	public int getId() {
		return id;
	}

	public Livro getLivroEmprestado() {
		return livroEmprestado;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public boolean isDevolvido() {
		return devolvido;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public String getDataDevolucao() {
		return dataDevolucao;
	}
}
