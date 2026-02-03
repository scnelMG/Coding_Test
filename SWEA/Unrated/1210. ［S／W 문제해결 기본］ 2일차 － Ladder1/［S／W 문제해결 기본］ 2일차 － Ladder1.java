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

			// 배열에 값 넣기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					grid[i][j] = sc.nextInt();
				}
			}

			// 시작점 찾기
			int colIdx = -1;
			for (int i = 0; i < N; i++) {
				if (grid[99][i] == 2) {
					colIdx = i;
					break;
				}
			}

			int rowIdx = 98;
			while (rowIdx > 0) {
				if (colIdx - 1 >= 0 && grid[rowIdx][colIdx - 1] == 1) { // 왼쪽에 길이 있으면
					while (colIdx - 1 >= 0 && grid[rowIdx][colIdx - 1] == 1) { // 길이 없을 때 까지 반복
						colIdx--;
					}
					rowIdx--; // 왼쪽 길 끝까지 도착하면 위로 한 칸

				} else if (colIdx + 1 < N && grid[rowIdx][colIdx + 1] == 1) { // 오른쪽에 길이 있으면
					while (colIdx + 1 < N && grid[rowIdx][colIdx + 1] == 1) { // 길이 없을 때 까지 반복
						if (colIdx == N - 1)
							break;
						colIdx++;
					}
					rowIdx--; // 오른쪽 길 끝까지 도착하면 위로 한 칸

				} else { // 좌우 모두 길 없을 때
					rowIdx--; // 위로 한칸
				}
			}
			System.out.println("#" + test_case + " " + colIdx);
		}
	}
}