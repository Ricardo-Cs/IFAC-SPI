package aplicacao;

import java.util.Scanner;

import modelo.Livro;
import modelo.Usuario;
import servico.ServicoEmprestimo;
import servico.ServicoLivro;
import servico.ServicoUsuario;
import repositorio.BDSimulado;

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
                    System.out.println("\nSaindo da aplicacao. Ate mais!\n");
                    break;
                default:
                    System.out.println("Opcao invalida. Por favor, tente novamente.");
            }
            System.out.println("\nPressione Enter para continuar...");
            scanner.nextLine();
        } while (opcaoPrincipal != 0);

        scanner.close();
	}
	private static void exibirMenuPrincipal() {
        System.out.println("\n---------------MENU PRINCIPAL DA BIBLIOTECA---------------\n");
        System.out.println("1. Gerenciar Livros");
        System.out.println("2. Gerenciar Usuarios");
        System.out.println("3. Gerenciar Emprestimos");
        System.out.println("0. Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private static void exibirMenuLivros() {
        System.out.println("\n---------------GERENCIAMENTO DE LIVROS---------------");
        System.out.println("1. Cadastrar Livro");
        System.out.println("2. Consultar Livro por ISBN");
        System.out.println("3. Listar Todos os Livros");
        System.out.println("4. Remover Livro");
        System.out.println("5. Buscar Livros por Autor");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opcao: ");
    }

    private static void exibirMenuUsuarios() {
        System.out.println("\n---------------GERENCIAMENTO DE USUARIOS---------------");
        System.out.println("1. Cadastrar Usuario");
        System.out.println("2. Consultar Usuario por CPF");
        System.out.println("3. Listar Todos os Usuarios");
        System.out.println("4. Remover Usuario");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opcao: ");
    }

    private static void exibirMenuEmprestimos() {
        System.out.println("\n---------------GERENCIAMENTO DE EMPRESTIMOS---------------");
        System.out.println("1. Realizar Emprestimo");
        System.out.println("2. Registrar Devolucao");
        System.out.println("3. Listar os Livros Emprestados");
        System.out.println("4. Verificar Livros Disponiveis");
        System.out.println("5. Histórico de Empréstimos");
        System.out.println("0. Voltar ao Menu Principal");
        System.out.print("Escolha uma opcao: ");
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
                	System.out.println(servicoLivro.consultarLivrosAutor(busca));
                	break;
                case 0: System.out.println("Voltando ao Menu Principal..."); break;
                default: System.out.println("Opcao invalida. Tente novamente.");
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
                	System.out.print("Insira o CPF do usuario para remover: ");
                	busca = scanner.nextLine();
                	servicoUsuario.removerUsuario(busca);
                	break;
                case 0: System.out.println("Voltando ao Menu Principal..."); break;
                default: System.out.println("Opcao invalida. Tente novamente.");
            }
            if (opcaoUsuario != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcaoUsuario != 0);
    }

    private void gerenciarEmprestimos() {
        int opcaoEmprestimo;
        String isbnLivro, cpfUsuario, emprestimoId, dataDevolucao;

        do {
            exibirMenuEmprestimos();
            opcaoEmprestimo = scanner.nextInt();
            scanner.nextLine();

            switch (opcaoEmprestimo) {
                case 1:
                    System.out.print("ISBN do Livro para emprestimo: ");
                    isbnLivro = scanner.nextLine();
                    Livro livroParaEmprestimo = BDSimulado.selecionarLivroPorISBN(isbnLivro);

                    if (livroParaEmprestimo == null) {
                        System.out.println("Livro com ISBN " + isbnLivro + " nao encontrado.");
                        break;
                    }

                    System.out.print("CPF do Usuario para emprestimo: ");
                    cpfUsuario = scanner.nextLine();
                    Usuario usuarioParaEmprestimo = BDSimulado.selecionarUsuarioPorCPF(cpfUsuario);

                    if (usuarioParaEmprestimo == null) {
                        System.out.println("Usuario com CPF " + cpfUsuario + " nao encontrado.");
                        break;
                    }
                    System.out.println(servicoEmprestimo.emprestarLivro(livroParaEmprestimo, usuarioParaEmprestimo));
                    break;
                case 2:
                    System.out.print("ID do Emprestimo para devolucao: ");
                    emprestimoId = scanner.nextLine();
                    System.out.print("Data de Devolucao (YYYY-MM-DD): ");
                    dataDevolucao = scanner.nextLine();
                    System.out.println(servicoEmprestimo.devolverLivro(emprestimoId, dataDevolucao));
                    break;
                case 3:
                    System.out.println(servicoEmprestimo.listarLivrosEmprestados());
                    break;
                case 4:
                    System.out.println(servicoEmprestimo.verificarLivrosDisponiveis());
                    break;
                case 5:
                	System.out.println(servicoEmprestimo.listarHistoricoEmprestimos());
                	break;
                case 0:
                    System.out.println("Voltando ao Menu Principal...");
                    break;
                default:
                    System.out.println("Opcao invalida. Tente novamente.");
            }
            if (opcaoEmprestimo != 0) {
                System.out.println("\nPressione Enter para continuar...");
                scanner.nextLine();
            }
        } while (opcaoEmprestimo != 0);
    }
}