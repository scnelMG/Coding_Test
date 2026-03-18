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
		// 1. N >= K -> 뒷걸음질 쳐야하는 경우 -> 그냥 -1 계속해야함
		if (N >= K)
			return N - K;

		if (K % 2 == 0) {
			// 짝수: 그냥 걷기 vs 순간이동 절반에서 오기
			return Math.min(K - N, solve(N, K / 2) + 1);
		} else {
			// 홀수: 그냥 걷기 vs 앞뒤로 1칸 이동 후 순간이동해서 오기
			return Math.min(K - N, Math.min(solve(N, (K + 1) / 2), solve(N, (K - 1) / 2)) + 2);
		}
	}
}