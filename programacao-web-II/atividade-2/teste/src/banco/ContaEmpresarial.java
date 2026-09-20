package banco;

public class ContaEmpresarial extends Conta {

    public ContaEmpresarial(int numero, String dono) {
        super(numero, dono);
        this.limite = 1200;
        this.investir(10);
    }

    @Override
    public void investir(double valor) {
        super.investir(valor);
        System.out.println("Conta empresarial investindo");
    }
}
