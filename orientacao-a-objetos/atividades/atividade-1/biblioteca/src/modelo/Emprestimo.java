package modelo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Emprestimo {
	private static int contador = 1;
	private String id;
	private Livro livroEmprestado;
	private Usuario usuario;
	private boolean devolvido = false;
	private LocalDate dataEmprestimo = LocalDate.now();
	private LocalDate dataDevolucao;
	
	public Emprestimo(Livro livroEmprestado, Usuario usuario) {
		this.livroEmprestado = livroEmprestado;
		this.usuario = usuario;
		this.id = definirId();
		contador++;
	}
	
	public Emprestimo(Livro livroEmprestado, Usuario usuario, LocalDate dataEmprestimo) {
		this(livroEmprestado, usuario);
		this.dataEmprestimo = dataEmprestimo;
	}
	
	private String definirId() {
		String id = Integer.toString(contador);
		while(id.length() < 3) id = "0" + id;
		String[] s = this.usuario.getNome().split(" ");
		id = s[s.length-1].charAt(0) + id;
		id = this.usuario.getNome().charAt(0) + id;
		return id.toUpperCase();
	}

	public String getId() {
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

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDevolvido(boolean devolvido) {
		this.devolvido = devolvido;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}
}
