import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] grid = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			int max_v = -1;
			for (int i = 0; i <= N - M; i++) {
				for (int j = 0; j <= N - M; j++) {
					int total = 0;
					for (int idx1 = 0; idx1 < M; idx1++) {
						for (int idx2 = 0; idx2 < M; idx2++) {
							total += grid[i + idx1][j + idx2];
						}
					}
					if (max_v < total)
						max_v = total;
				}
			}
			System.out.println("#" + test_case + " " + max_v);

		}
	}
}