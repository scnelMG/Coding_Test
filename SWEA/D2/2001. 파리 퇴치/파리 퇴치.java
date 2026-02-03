import java.util.Arrays;
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

			int[][] sum_grid = new int[N + 1][N + 1];

			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
                    // 누적합 배열: 배열의 왼쪽 값 + 배열의 위쪽 값 - 배열의 왼쪽 위 대각선 값 + 자기 자신
					sum_grid[i][j] = sum_grid[i][j - 1] + sum_grid[i - 1][j] - sum_grid[i - 1][j - 1]
							+ grid[i - 1][j - 1];
				}
			}

			int max_v = -1;
			for (int i = M; i <= N; i++) {
				for (int j = M; j <= N; j++) {
					// 부분합 구하기: 자기 자신 - 부분 왼쪽 끝값 - 부분 위쪽 끝값 + 끝값의 대각선 값
					max_v = Math.max(max_v,
							sum_grid[i][j] - sum_grid[i][j - M] - sum_grid[i - M][j] + sum_grid[i - M][j - M]);
				}
			}
			System.out.println("#" + test_case + " " + max_v);

		}
	}
}