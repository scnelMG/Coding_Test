import java.util.Scanner;

class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();

		int res = solve(N, K);
		System.out.println(res);

	}

	static int solve(int N, int K) {
		if (N >= K)
			return N - K;

		if (K % 2 == 0) {
			return Math.min(K - N, 1 + solve(N, K / 2));
		} else {
			return Math.min(solve(N, K + 1), solve(N, K - 1)) + 1;
		}

	}
}