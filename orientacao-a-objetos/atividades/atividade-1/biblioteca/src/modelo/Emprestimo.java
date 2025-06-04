package modelo;

import java.time.LocalDate;

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
		String id = String.format("%03d", contador);
		String nomeCompleto = this.usuario.getNome();
		String primeiraInicial = "";
		String ultimaInicial = "";

		if (nomeCompleto != null && !nomeCompleto.isEmpty()) {
			primeiraInicial = String.valueOf(nomeCompleto.charAt(0));
			String[] partesDoNome = nomeCompleto.split(" ");
			if (partesDoNome.length > 1) {
				ultimaInicial = String.valueOf(partesDoNome[partesDoNome.length - 1].charAt(0));
			} else {
				ultimaInicial = primeiraInicial;
			}
		}
		return (primeiraInicial + ultimaInicial + id).toUpperCase();
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

	public void setDevolvido(boolean devolvido) {
	    this.devolvido = devolvido;
	}

	public LocalDate getDataEmprestimo() {
		return dataEmprestimo;
	}

	public LocalDate getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(LocalDate dataDevolucao) {
	    this.dataDevolucao = dataDevolucao;
	}
}