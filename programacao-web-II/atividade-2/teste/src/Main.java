import banco.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Conta conta1 = new ContaUniversitaria(1,"João");
        conta1.depositar(500);
        conta1.sacar(100);
        conta1.investir(50);
        System.out.println(conta1.verSaldo());

        Conta conta2 = new ContaEmpresarial(2,"Ana");
        conta2.depositar(600);
        conta2.sacar(50);
        conta2.investir(100);
        System.out.println(conta2.verSaldo());

        Conta conta3 = new ContaUniversitaria(3,"Carlos");
        conta3.depositar(100);
        conta3.sacar(50);
        System.out.println(conta3.verSaldo());

        Conta conta4 = new ContaEmpresarial(4,"Roberto");
        conta4.depositar(6000);
        conta4.sacar(50);
        conta4.investir(500);
        System.out.println(conta4.verSaldo());

        Conta conta5 = new ContaBlack(5,"Marina");
        conta5.depositar(10000);
        conta5.sacar(500);
        conta5.investir(1000);
        System.out.println(conta5.verSaldo());

        Conta conta6 = new ContaBlack(6,"Lucas");
        conta6.depositar(2000);
        conta6.investir(300);
        System.out.println(conta6.verSaldo());

        List<Conta> contas = new ArrayList<>();
        contas.add(conta1);
        contas.add(conta2);
        contas.add(conta3);
        contas.add(conta4);
        contas.add(conta5);
        contas.add(conta6);

        Relatorio relatorio = new Relatorio();
        relatorio.imprimirValoresDasContas(contas);
    }



}