import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for (int tc = 1; tc <= 10; tc++) {
			int T = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			int res = cal(N, M);
			System.out.println("#" + tc + " " + res);
		}
	}

	static int cal(int N, int M) {
		if (M == 0)
			return 1;
		int tmp = cal(N, M / 2);
		if (M % 2 == 1) {
			return tmp * tmp * N;
		} else {
			return tmp * tmp;
		}
	}

}
