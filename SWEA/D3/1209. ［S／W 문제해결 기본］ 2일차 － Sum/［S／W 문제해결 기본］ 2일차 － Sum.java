import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = 10;
		int N = 100;

		for (int test_case = 1; test_case <= T; test_case++) {
			test_case = sc.nextInt();
			int[][] grid = new int[N][N];

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					grid[i][j] = sc.nextInt();
				}
			}
			int max_v = 0;

			for (int i = 0; i < N; i++) {
				int total = 0;
				for (int j = 0; j < N; j++) {
					total += grid[i][j];
				}
				if (max_v < total)
					max_v = total;
			}

			for (int j = 0; j < N; j++) {
				int total = 0;
				for (int i = 0; i < N; i++) {
					total += grid[i][j];
				}
				if (max_v < total)
					max_v = total;
			}

			int cross1 = 0;
			for (int i = 0; i < N; i++) {
				cross1 += grid[i][i];
			}

			int cross2 = 0;
			for (int i = 0; i < N; i++) {
				cross2 += grid[i][N - i - 1];
			}
			max_v = Math.max(max_v, cross1);
			max_v = Math.max(max_v, cross2);

			System.out.println("#" + test_case + " " + max_v);
		}
	}
}