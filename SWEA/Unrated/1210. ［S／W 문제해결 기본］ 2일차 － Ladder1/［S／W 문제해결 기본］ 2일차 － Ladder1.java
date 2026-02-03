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

			int colIdx = -1;
			for (int i = 0; i < N; i++) {
				if (grid[99][i] == 2) {
					colIdx = i;
					break;
				}
			}
			int rowIdx = 98;
			int cnt = 0;
			while (rowIdx > 0) {
				// 왼쪽
				if (colIdx - 1 >= 0 && grid[rowIdx][colIdx - 1] == 1) {
					while (colIdx - 1 >= 0 && grid[rowIdx][colIdx - 1] == 1) {
						colIdx--;
					}

					rowIdx--;
				} else if (colIdx + 1 < N && grid[rowIdx][colIdx + 1] == 1) { // 오른쪽
					while (colIdx + 1 < N && grid[rowIdx][colIdx + 1] == 1) {
						if (colIdx == N - 1)
							break;
						colIdx++;
					}

					rowIdx--;
				} else { // 위로
					rowIdx--;
				}
				cnt++;
			}

			System.out.println("#" + test_case + " " + colIdx);

		}
	}
}