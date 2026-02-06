import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 0; tc < T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();

			int res1 = (M * 2 - N);
			int res2 = M - res1;
			System.out.println(res1 + " " + res2);

		}

	}
}
