package 박민규.CodeTree.격자위의편안한상태;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();

		int grid[][] = new int[n][n];

		int[] dr = { -1, 1, 0, 0 }; // 상하좌우
		int[] dc = { 0, 0, -1, 1 };

		for (int i = 0; i < m; i++) {
			int r = sc.nextInt() - 1; // 인덱스값을 위해 -1
			int c = sc.nextInt() - 1;
			grid[r][c] = 1; // 현재 위치 색칠
			int cnt = 0;
			for (int d = 0; d < 4; d++) { // 상하좌우 보고 색칠되어 있는거 개수 세기
				if (r + dr[d] < 0 || r + dr[d] >= n || c + dc[d] < 0 || c + dc[d] >= n) {
					continue;
				} else if (grid[r + dr[d]][c + dc[d]] == 1) {
					cnt++;
				}
			}
			if (cnt == 3)
				System.out.println(1);
			else
				System.out.println(0);
		}

	}
}