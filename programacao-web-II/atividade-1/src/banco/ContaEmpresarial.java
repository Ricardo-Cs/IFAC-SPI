package banco;

public class ContaEmpresarial extends Conta{

    public ContaEmpresarial(int numero, String dono) {
        super(numero, dono);
    }

    @Override
    public String getTipoConta() {
        return "empresarial";
    }
}
