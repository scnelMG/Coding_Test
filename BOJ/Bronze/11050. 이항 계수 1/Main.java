import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int res = fac(N) / fac(N - K) / fac(K);
		System.out.println(res);

	}

	static int fac(int N) {
		if (N <= 1) {
			return 1;
		}

		return fac(N - 1) * N;
	}
}
