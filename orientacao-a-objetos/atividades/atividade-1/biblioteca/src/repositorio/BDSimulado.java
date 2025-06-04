package repositorio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.Emprestimo;
import modelo.Livro;
import modelo.Usuario;

public class BDSimulado {
	private static HashMap<String, Livro> livros = new HashMap<String, Livro>();
	private static HashMap<String, Usuario> usuarios = new HashMap<String, Usuario>();
	private static HashMap<String, Emprestimo> emprestimos = new HashMap<String, Emprestimo>();

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
			if(livro.getAutor().equalsIgnoreCase(autor)) {
				livrosAutor.add(livro);
			}
		}
		return livrosAutor;
	}

	public static void removerLivro(String ISBN) {
		livros.remove(ISBN);
	}

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

	public static boolean emprestarLivro(Livro livro, Usuario usuario) {
		if(livro == null || usuario == null) {
			return false;
		}
		Livro livroExistente = livros.get(livro.getISBN());
		if(livroExistente == null || !livroExistente.emprestarExemplar()) {
			return false;
		}
		Emprestimo emprestimo = new Emprestimo(livroExistente, usuario);
		emprestimos.put(emprestimo.getId(), emprestimo);
		return true;
	}

	public static boolean devolverLivro(String emprestimoId, LocalDate dataDevolucao) {
	    Emprestimo emprestimo = emprestimos.get(emprestimoId);
	    if (emprestimo == null || emprestimo.isDevolvido()) {
	        return false;
	    }
	    emprestimo.setDevolvido(true);
	    emprestimo.setDataDevolucao(dataDevolucao);
	    emprestimo.getLivroEmprestado().devolverExemplar();
	    return true;
	}

	public static HashMap<String, Emprestimo> getEmprestimos() {
		return emprestimos;
	}

	public static ArrayList<Livro> livrosDisponiveis() {
		ArrayList<Livro> livrosDisponiveis = new ArrayList<Livro>();
		for(Livro livro: livros.values()) {
			if(livro.getExemplaresDisponiveis() > 1) livrosDisponiveis.add(livro);
		}
		return livrosDisponiveis;
	}

	public static HashMap<String, Livro> livrosEmprestados() {
		HashMap<String, Livro> livrosEmprestados = new HashMap<>();
        for(Emprestimo emprestimo : emprestimos.values()) {
            if(!emprestimo.isDevolvido()) {
                livrosEmprestados.put(emprestimo.getId(), emprestimo.getLivroEmprestado());
            }
        }
        return livrosEmprestados;
	}

    public static Emprestimo selecionarEmprestimoPorId(String id) {
        return emprestimos.get(id);
    }
}
