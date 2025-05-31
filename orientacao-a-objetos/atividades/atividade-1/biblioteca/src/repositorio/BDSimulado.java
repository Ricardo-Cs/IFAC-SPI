package repositorio;

import java.util.HashMap;
import modelo.Livro;
import modelo.Usuario;

public class BDSimulado {
	private static HashMap<String, Livro> livros = new HashMap<String, Livro>();
	private static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
	
	
	public static HashMap<String, Livro> getLivros() {
		return livros;
	}
	public static HashMap<String, Usuario> getUsuarios() {
		return usuarios;
	}
	
	public static boolean addLivro(Livro livro) {
		String ISBN = livro.getISBN();
		if(livros.containsKey(ISBN)) {
			return false;
		}
		livros.put(ISBN, livro);
		return true;
	}
	
	public static boolean addUsuario(Usuario usuario) {
		String cpf = usuario.getCpf();
		if(usuarios.containsKey(cpf)) {
			return false;
		}
		usuarios.put(cpf, usuario);
		return true;
	}
	
	public static boolean selecionarCODlivro(String ISBN) {
		if(livros.containsKey(ISBN)) {
			return true;
		}
		return false;
	}
	
	public static void removerLivro(String ISBN) {
		livros.remove(ISBN);
	}
}
