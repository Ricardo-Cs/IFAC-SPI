package aplicacao;

import java.util.Scanner;

import servico.ServicoEmprestimo;
import servico.ServicoLivro;
import servico.ServicoUsuario;

public class Aplicacao {
	private ServicoLivro servicoLivro;
	private ServicoUsuario servicoUsuario;
	private ServicoEmprestimo servicoEmprestimo;
	private Scanner scanner;
	
	public Aplicacao() {
		this.servicoLivro = new ServicoLivro();
		this.servicoUsuario = new ServicoUsuario();
		this.servicoEmprestimo = new ServicoEmprestimo();
		this.scanner = new Scanner(System.in);
	}

	public static void main(String[] args) {
		Aplicacao app = new Aplicacao();
		app.executar();
	}

	public void executar() {
		int opcaoPrincipal;
        do {
            exibirMenuPrincipal();
            opcaoPrincipal = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoPrincipal) {
                case 1:
                    gerenciarLivros();
                    break;
                case 2:
                    gerenciarUsuarios();
                    break;
                case 3:
                    gerenciarEmprestimos();
                    break;
                case 0:
                    System.out.println("\nSaindo da aplicação. Até mais!\n");
                    break;
                default:
                    System.out.println("Opção inválida. Por favor, tente novamente.");
            }
            System.out.println("\nPressione Enter para continuar...");
            scanner.nextLine(); // Espera o usuário pressionar Enter
        } while (opcaoPrincipal != 0);

        scanner.close();
	}
	private static void exibirMenuPrincipal() {
        System.out.println("\n---------------MENU PRINCIPAL DA BIBLIOTECA---------------\n");
        System.out.println("1. Gerenciar Livros");
        System.out.println("2. Gerenciar Usuários");
        System.out.println("3. Gerenciar Empréstimos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opção: ");
    }
	
    private static void exibirMenuLivros() {
        System.out.println("\n==== GERENCIAMENTO DE LIVROS ====");
        System.out.println("1. Cadastrar Livro");
        System.out.println("2. Consultar Livro por ISBN");
        System.out.println("3. Listar Todos os Livros");
        System.out.println("4. Remover Livro");
        System.out.println("5. Buscar Livros por Autor");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }

    private static void exibirMenuUsuarios() {
        System.out.println("\n==== GERENCIAMENTO DE USUÁRIOS ====");
        System.out.println("1. Cadastrar Usuário");
        System.out.println("2. Consultar Usuário por CPF");
        System.out.println("3. Listar Todos os Usuários");
        System.out.println("4. Remover Usuário");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }

    private static void exibirMenuEmprestimos() {
        System.out.println("\n==== GERENCIAMENTO DE EMPRÉSTIMOS ====");
        System.out.println("1. Realizar Empréstimo");
        System.out.println("2. Registrar Devolução");
        System.out.println("3. Listar Todos os Livros Emprestados");
        System.out.println("4. Verificar Livros Disponíveis");
        System.out.println("5. Guardar Histórico de Empréstimo (Automático na devolução)");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opção: ");
    }
    
    private void gerenciarLivros() {
    	int opcaoLivro;
        do {
            exibirMenuLivros();
            opcaoLivro = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoLivro) {
                case 1:
                	System.out.println(servicoLivro.cadastrarLivro(Utils.inserirDadosLivro()));
                	break;
                case 2: 
                	System.out.print("Insira o ISBN para busca: ");
                	String busca = scanner.nextLine();
                	System.out.println(servicoLivro.consultarLivro(busca));
                	break;
                case 3: 
                	System.out.println(servicoLivro.listarLivros());
                	break;
                case 4: 
                	System.out.print("Insira o ISBN do livro para remover: ");
                	busca = scanner.nextLine();
                	servicoLivro.removerLivro(busca);
                	break;
                case 5: 
                	System.out.print("Insira o autor para busca: ");
                	busca = scanner.nextLine();
                	servicoLivro.consultarLivrosAutor(busca);
                	break;
                case 0: System.out.println("Voltando ao Menu Principal..."); break;
                default: System.out.println("Opção inválida. Tente novamente.");
            }
            if (opcaoLivro != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcaoLivro != 0);
    }
    
    private void gerenciarUsuarios() {
    	int opcaoUsuario;
    	String busca;
        do {
            exibirMenuUsuarios();
            opcaoUsuario = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoUsuario) {
                case 1: 
                	System.out.println(servicoUsuario.cadastrarUsuario(Utils.inserirDadosUsuario()));
                	break;
                case 2:
                	System.out.print("Insira o CPF para busca: ");
                	busca = scanner.nextLine();
                	System.out.println(servicoUsuario.consultarUsuario(busca)); 
                	break;
                case 3: 
                	System.out.println(servicoUsuario.listarUsuarios());
                	break;
                case 4: 
                	System.out.print("Insira o CPF do usuário para remover: ");
                	busca = scanner.nextLine();
                	servicoUsuario.removerUsuario(busca);
                	break;
                case 0: System.out.println("Voltando ao Menu Principal..."); break;
                default: System.out.println("Opção inválida. Tente novamente.");
            }
            if (opcaoUsuario != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcaoUsuario != 0);
    }
    
    private void gerenciarEmprestimos() {
    	System.out.print("Emprestimos");
    }
}
