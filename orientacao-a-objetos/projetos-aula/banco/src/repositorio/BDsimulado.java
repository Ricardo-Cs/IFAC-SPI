package repositorio;

import java.util.HashMap;

import modelo.Cliente;
import modelo.Conta;

public class BDsimulado {
	private static HashMap<String, Cliente> clientes = new HashMap<String, Cliente>();
	private static HashMap<String, Conta> contas = new HashMap<String, Conta>();
	
	public static HashMap<String, Cliente> getClientes() {
		return clientes;
	}
	
	public static HashMap<String, Conta> getContas() {
		return contas;
	}
	
}
