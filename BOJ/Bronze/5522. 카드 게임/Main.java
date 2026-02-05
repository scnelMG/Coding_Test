import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int res = 0;
		for (int i = 0; i < 5; i++) {
			res += sc.nextInt();
		}
		System.out.println(res);

	}
}
