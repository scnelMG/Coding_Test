import java.util.Scanner;

public class Solution {
	static int N, res;
	static int[] cols;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			N = sc.nextInt();
			cols = new int[N];
			res = 0;

			solve(0);

			System.out.println("#" + tc + " " + res);
		}
	}

	static void solve(int row) {
		if (row == N) {
			res++;
			return;
		}

		for (int c = 0; c < N; c++) {
			cols[row] = c;

			if (isOkay(row)) {
				solve(row + 1);
			}
		}
	}

	static boolean isOkay(int row) {
		for (int i = 0; i < row; i++) {
			if (cols[i] == cols[row]) {
				return false;
			}

			if (Math.abs(row - i) == Math.abs(cols[row] - cols[i])) {
				return false;
			}
		}

		return true;
	}

}
