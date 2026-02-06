import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int min_v = 10000000;
		int max_v = -10000000;
		for (int i = 0; i < N; i++) {
			int a = sc.nextInt();
			if (a < min_v)
				min_v = a;
			if (a > max_v)
				max_v = a;
		}
		System.out.println(min_v + " " + max_v);
	}
}
