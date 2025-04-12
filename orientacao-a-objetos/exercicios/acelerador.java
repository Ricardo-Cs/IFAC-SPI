// https://olimpiada.ic.unicamp.br/pratique/p2/2020/f1/acelerador/
import java.util.Scanner;

public class acelerador
{
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int D = s.nextInt() - 5;
		D %= 8;

		System.out.println(D);
	}
}
