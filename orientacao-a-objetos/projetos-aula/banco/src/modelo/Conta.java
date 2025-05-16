package modelo;
import java.text.DecimalFormat;

public class Conta {
	private Cliente titular;
	private double saldo;
	private String numero;
	private String agencia;
	private double limite;
	public static int contador = 0;
	DecimalFormat dfDinheiro = new DecimalFormat("###,##0.00");

	public Conta(String numero, String agencia) {
		this.numero = numero;
		this.agencia = agencia;
		this.saldo = 0;
		this.limite = 0;
		contador++;
	}
	
	public Conta(String numero, String agencia, Cliente titular) {
		this(numero, agencia);
		this.titular = titular;
	}
	
	
	public void setTitular(Cliente titular) {
		this.titular = titular;
	}

	public boolean sacar(double valor) {
		if (this.saldo + this.limite >= valor) {                                                                                                                                                                                                                  
			this.saldo -= valor;
			return true;
		}
		return false;
	}
	
	public void depositar(double valor) {
		this.saldo += valor;
	}
	
	public boolean transferir(Conta destino, double valor) {
		if (this.sacar(valor)) {
			destino.depositar(valor);
			return true;
		}
		return false;
	}
	
	public String emitirSaldo() {
		//String valor = String.format("%.2f", this.saldo);
		String valor = dfDinheiro.format(this.saldo);
		if (this.saldo < 0 ) return "R$ " + dfDinheiro.format(Math.abs(this.saldo)) + " D";
		return "R$ " + valor;
		
	}
	
	@Override
	public String toString() {
		String relatorio = "Agência: " + this.agencia;
		relatorio += "\nConta: " + this.numero;
		relatorio += "\n" + this.titular.toString();
		relatorio += "\nSaldo: " + this.emitirSaldo();
		double limiteDisponivel = (this.saldo >= 0 ? this.limite : this.limite + this.saldo);
		
		relatorio += "\nLimite Disponível: R$ " + dfDinheiro.format(limiteDisponivel);
		return relatorio;
	}
}
