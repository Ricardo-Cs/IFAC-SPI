package aplicacao;

import java.util.Scanner;

import modelo.Livro;
import modelo.Usuario;

public class Utils {
	private static Scanner scanner = new Scanner(System.in);
	
	public static Livro inserirDadosLivro() {
		System.out.println("\n--- CADASTRO DE LIVRO ---");
	        System.out.print("Título: ");
	        String titulo = scanner.nextLine();
	        System.out.print("Autor: ");
	        String autor = scanner.nextLine();
	        System.out.print("ISBN: ");
	        String isbn = scanner.nextLine();
	        System.out.print("Ano: ");
	        int ano = scanner.nextInt();
	        scanner.nextLine(); // Consumir a quebra de linha
	        System.out.print("Editora: ");
	        String editora = scanner.nextLine();
	        System.out.print("Quantidade de Exemplares: ");
	        int quantidade = scanner.nextInt();
	        scanner.nextLine(); // Consumir a quebra de linha

        	return new Livro(titulo, autor, isbn, ano, editora, quantidade);
	}
	
	public static Usuario inserirDadosUsuario() {
		System.out.println("\n--- CADASTRO DE USUÁRIO ---");
	        System.out.print("Nome do Usuário: ");
	        String nome = scanner.nextLine();
	        System.out.print("CPF do Usuário: ");
	        String cpf = scanner.nextLine();
	        System.out.print("E-mail do Usuário: ");
	        String email = scanner.nextLine();

        	return new Usuario(nome, cpf, email);
	}
}
