package banco;

public class ContaUniversitaria extends Conta{

    public ContaUniversitaria(int numero, String dono) {
        super(numero, dono);
        this.limite = 1200;
    }

    @Override
    public String getTipoConta() {
        return "universitária";
    }
}
