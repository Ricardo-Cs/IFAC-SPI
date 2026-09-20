import banco.Conta;
import banco.ContaEmpresarial;
import banco.ContaUniversitaria;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Conta> contas = new ArrayList<Conta>();

        Conta conta = new Conta(1,"João");
        ContaEmpresarial contaEmpresarial = new ContaEmpresarial(2, "Maria");
        ContaUniversitaria contaUniversitaria = new ContaUniversitaria(3, "Pedro");

        contas.add(conta);
        contas.add(contaEmpresarial);
        contas.add(contaUniversitaria);

        try{
            conta.depositar(10000);
            contaUniversitaria.depositar(5500);
            contaEmpresarial.depositar(1000);
        }catch (IllegalArgumentException erro){
            System.out.println("O valor para depósito deve ser maior que 0");
        }

        try{
            conta.sacar(500);
            contaEmpresarial.sacar(1000);
            contaUniversitaria.sacar(5000);
        }catch (IllegalStateException erro){
            System.out.println("Valor de saldo insuficiente");
        }catch (IllegalArgumentException erro){
            System.out.println("O valor de saque tem que ser maior que zero");
        }

        System.out.println("\n\tSaldo atual das contas");
        for (Conta contaI: contas) {
            System.out.print("\nSaldo da conta " + contaI.getTipoConta() + " igual a: " + contaI.verSaldo());
        }
    }
}