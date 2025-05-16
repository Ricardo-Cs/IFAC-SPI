package aplicacao;
import modelo.Cliente;
import modelo.Conta;

public class Aplicacao {

	public static void main(String[] args) {
		Conta cPedro = new Conta("12345", "678");
		Cliente cliente1 = new Cliente("Pedro", "123456789-00", "26-01-2000");
		cliente1.setEndereco("Rua A");
		cPedro.setTitular(cliente1);
		//System.out.println(cliente1); 
		System.out.println(cPedro);
	}

}
