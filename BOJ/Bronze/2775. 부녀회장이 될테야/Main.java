import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 0; tc < T; tc++) {
			int K = sc.nextInt(); // 층
			int N = sc.nextInt(); // 호
			System.out.println(solve(K, N));
			
		}
	}

	static int solve(int K, int N) {
		if (K == 0)
			return N;
		int sum = 0;
		for (int i = 1; i <= N; i++) {
			sum += solve(K - 1, i);
		}
		return sum;

	}
}