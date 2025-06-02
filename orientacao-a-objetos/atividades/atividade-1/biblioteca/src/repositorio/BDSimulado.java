package repositorio;

import java.util.ArrayList;
import java.util.HashMap;

import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;

public class BDSimulado {
	private static HashMap<String, Livro> livros = new HashMap<String, Livro>();
	private static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
	private static HashMap<String, Emprestimo> emprestimos = new HashMap<String, Emprestimo>();
	
	// Metodos Livro
	public static HashMap<String, Livro> getLivros() {
		return livros;
	}
	
	public static boolean adicionarLivro(Livro livro) {
		String ISBN = livro.getISBN();
		if(livros.containsKey(ISBN)) {
			return false;
		}
		livros.put(ISBN, livro);
		return true;
	}
	
	public static Livro selecionarLivroPorISBN(String ISBN) {
		if(livros.containsKey(ISBN)) {
			return livros.get(ISBN);
		}
		return null;
	}
	
	public static ArrayList<Livro> selecionarLivroPorAutor(String autor) {
		ArrayList<Livro> livrosAutor = new ArrayList<Livro>();
		for(Livro livro: livros.values()) {
			if(livro.getAutor() == autor) {
				livrosAutor.add(livro);
			}
		}
		
		return livrosAutor;
	}
	
	public static void removerLivro(String ISBN) {
		livros.remove(ISBN);
	}
	
	// Metodos Usuario
	public static HashMap<String, Usuario> getUsuarios() {
		return usuarios;
	}
	
	public static boolean adicionarUsuario(Usuario usuario) {
		String cpf = usuario.getCpf();
		if(usuarios.containsKey(cpf)) {
			return false;
		}
		usuarios.put(cpf, usuario);
		return true;
	}
	
	public static Usuario selecionarUsuarioPorCPF(String CPF) {
		if(usuarios.containsKey(CPF)) {
			return usuarios.get(CPF);
		}
		return null;
	}
	
	public static void removerUsuario(String CPF) {
		usuarios.remove(CPF);
	}
	
	// Metodos Emprestimo 
	public static boolean emprestarLivro(Livro livro, Usuario usuario) {
		if(livros.containsKey(livro.getISBN()) && livro.getQtdeExemplar() <= 1) {
			return false;
		}
		Emprestimo emprestimo = new Emprestimo(livro, usuario);
		emprestimos.put(emprestimo.getId(), emprestimo);
		return true;
	}
	
//	public static boolean devolverLivro(Livro livro, Usuario usuario, String dataEmprestimo) {
//		if(livros.)
//	}
}
