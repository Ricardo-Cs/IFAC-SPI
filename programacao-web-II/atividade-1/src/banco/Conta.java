package banco;

public class Conta {

    static public double juros;

    public int numero;
    public String dono;
    private double saldo;
    public double limite;

    public Conta(int numero,String dono){
        System.out.println("Criando a uma nova conta " + getTipoConta());
        this.numero = numero;
        this.dono = dono;
        this.saldo = 0;
        this.limite = 100;
    }

    public void sacar(double valor){
        if(valor < 0){
            IllegalArgumentException erro = new IllegalArgumentException();
            throw erro;
        }

        if(valor <= this.saldo) {
            this.saldo = this.saldo - valor;
            System.out.println("Valor sacado na conta " + getTipoConta() + ": " + valor);
        }else{
            IllegalStateException erro = new IllegalStateException();
            throw erro;
        }

    }

    public void depositar(double valor){
        if(valor < 0){
            IllegalArgumentException erro = new IllegalArgumentException();
            throw erro;
        }
        this.saldo  = this.saldo + valor;
        System.out.println("Valor depositado na conta " + getTipoConta() + ": " + valor);
    }

    public double verSaldo(){
        return this.saldo;
    }

    public String getTipoConta() {
        return "comum";
    }
}
