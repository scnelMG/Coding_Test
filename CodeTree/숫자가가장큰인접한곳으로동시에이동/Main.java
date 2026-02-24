package 박민규.CodeTree.숫자가가장큰인접한곳으로동시에이동;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int t = sc.nextInt();
		int[][] grid = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();
		int[][] marbles = new int[m][2];
		for (int i = 0; i < m; i++) {
			marbles[i][0] = sc.nextInt() - 1;
			marbles[i][1] = sc.nextInt() - 1;
		}

		int cnt = m;
		for (int time = 1; time <= t; time++) {

			for (int i = 0; i < m; i++) {
				if (marbles[i][0] == -1)
					continue;
				int[] tmpList = nextRC(marbles[i][0], marbles[i][1], grid);
				marbles[i][0] = tmpList[0];
				marbles[i][1] = tmpList[1];
			}
			for (int i = 0; i < m - 1; i++) {
				int gapCnt = 0;
				if (marbles[i][0] == -1 && marbles[i][1] == -1)
					continue;
				for (int j = i + 1; j < m; j++) {
					if (marbles[i][0] == marbles[j][0] && marbles[i][1] == marbles[j][1]) {
						marbles[j][0] = -1;
						marbles[j][1] = -1;
						gapCnt++;
					}
				}
				if (gapCnt > 0) {
					marbles[i][0] = -1;
					marbles[i][1] = -1;
					cnt -= gapCnt + 1;
				}
			}
		}
		System.out.println(cnt);

	}

	public static int[] nextRC(int r, int c, int[][] grid) {
		int maxV = 0;
		int maxIdx = -1;
		int n = grid.length;

		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
				continue;
			}
			if (grid[nr][nc] > maxV) {
				maxV = grid[nr][nc];
				maxIdx = i;
			}
		}
		int[] nextRC_Arr = { r + dr[maxIdx], c + dc[maxIdx] };
		return nextRC_Arr;
	}
}