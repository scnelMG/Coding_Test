import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		java.util.Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int r = sc.nextInt();
		int c = sc.nextInt();
		int d = sc.nextInt();

		int[] dr = { -1, 0, 1, 0 }; // 북동남서
		int[] dc = { 0, 1, 0, -1 };
		int dIdx = d;
		int[][] grid = new int[N + 2][M + 2];

		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		r++;
		c++;

		int cnt = 1;
		grid[r][c] = 2; // 청소
		cnt++;
		int tmp = 0;
		while (tmp < 50) {
			tmp++;
			// 청소
			System.out.println("청소");

			System.out.println(grid[r + 1][c] + " " + grid[r - 1][c] + " " + grid[r][c + 1] + " " + grid[r][c - 1]);
			System.out.println(r + " " + c);
			if ((grid[r + 1][c] != 0) && (grid[r][c + 1] != 0) && (grid[r - 1][c] != 0) && (grid[r][c - 1] != 0)) {
				dIdx = (dIdx + 2) % 4;
				System.out.println(dIdx + "로 이동 2번케이스");
				r += dr[dIdx]; // 후진
				c += dc[dIdx];
				if (grid[r][c] == 1) {
					System.out.println("끝");
					break;
				}

			} else if ((grid[r + 1][c] == 0) || (grid[r][c + 1] == 0) || (grid[r - 1][c] == 0)
					|| (grid[r][c - 1] == 0)) {
				dIdx = (dIdx + 3) % 4; // 반시계 90도 회전
				System.out.println(dIdx + " 3번케이스");

				if (grid[r + dr[dIdx]][c + dc[dIdx]] == 0) {
					r += dr[dIdx];
					c += dc[dIdx];
					grid[r][c] = 2; // 청소
					cnt++;
				}
			}
		}
		System.out.println(cnt);

	}
}
