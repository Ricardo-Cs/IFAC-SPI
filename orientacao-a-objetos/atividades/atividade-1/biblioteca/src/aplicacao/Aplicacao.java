package aplicacao;

import servico.ServicoLivro;
import servico.ServicoUsuario;

public class Aplicacao {

	public static void main(String[] args) {
		ServicoLivro servico = new ServicoLivro();
		servico.criarLivro("Pequeno Príncipe", "Euzebio", "1", "Marvel", 100);
		servico.criarLivro("O Pente do Rei Careca", "Ricardo", "2", "DComics", 90);
		/*servico.listarLivros();
		
		ServicoUsuario servico2 = new ServicoUsuario();
		servico2.criarUsuario("Pedro", "101", "pedrinho@gmail.com");
		servico2.listarUsuarios();
		*/
		
		servico.criarLivro("Harry Potter", "Euzebio", "3", "Atumalaca", 10);
		//servico.consultarLivro("3");
		//servico.removerLivro("3");
		
		//servico.consultarLivro("3");
		servico.consultarLivrosAutor("Euzebio");
	}

}
