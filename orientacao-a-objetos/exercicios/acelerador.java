// https://olimpiada.ic.unicamp.br/pratique/p2/2020/f1/acelerador/
import java.util.Scanner;

public class acelerador
{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int D = s.nextInt() - 5;
		int resultado = D % 8;
		
		if (resultado == 1) System.out.println(1);
		else if (resultado == 2) System.out.println(2);
		else System.out.println(3);
	}
}
