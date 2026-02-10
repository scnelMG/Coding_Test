import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		double res = a - a * ((double) b / 100);
		if (res >= 100) {
			System.out.println(0);
		} else
			System.out.println(1);

	}
}
