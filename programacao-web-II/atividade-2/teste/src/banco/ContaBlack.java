package banco;

public class ContaBlack extends Conta {

    private CartaoCredito cartaoCredito;

    public ContaBlack(int numero, String dono) {
        super(numero, dono);
        this.limite = 10000;
        investir(10);
    }

    @Override
    public void investir(double valor) {
        super.investir(valor);
        System.out.println("Conta Black investindo");
    }
}