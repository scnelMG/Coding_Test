import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static int[][] grid = new int[N][N];
	static int[] dr = { -1, 0, 1, 0 }; // 상 : 0, 우 : 1, 하 : 2, 좌 : 3
	static int[] dc = { 0, 1, 0, -1 };
	static int[][] warmHole;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			grid = new int[N][N];
			warmHole = new int[5][4];
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 4; j++) {
					warmHole[i][j] = -1;
				}
			}
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					int num = Integer.parseInt(st.nextToken());
					grid[i][j] = num;
					if (num == 6) {
						if (warmHole[num - 6][0] == -1) {
							warmHole[num - 6][0] = i;
							warmHole[num - 6][1] = j;
						} else {
							warmHole[num - 6][2] = i;
							warmHole[num - 6][3] = j;
						}

					}
					if (num == 7) {
						if (warmHole[num - 6][0] == -1) {
							warmHole[num - 6][0] = i;
							warmHole[num - 6][1] = j;
						} else {
							warmHole[num - 6][2] = i;
							warmHole[num - 6][3] = j;
						}

					}
					if (num == 8) {
						if (warmHole[num - 6][0] == -1) {
							warmHole[num - 6][0] = i;
							warmHole[num - 6][1] = j;
						} else {
							warmHole[num - 6][2] = i;
							warmHole[num - 6][3] = j;
						}

					}
					if (num == 9) {
						if (warmHole[num - 6][0] == -1) {
							warmHole[num - 6][0] = i;
							warmHole[num - 6][1] = j;
						} else {
							warmHole[num - 6][2] = i;
							warmHole[num - 6][3] = j;
						}

					}
					if (num == 10) {
						if (warmHole[num - 6][0] == -1) {
							warmHole[num - 6][0] = i;
							warmHole[num - 6][1] = j;
						} else {
							warmHole[num - 6][2] = i;
							warmHole[num - 6][3] = j;
						}

					}
				}
			}

			int maxV = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (grid[i][j] == 0) {
						for (int d = 0; d < 4; d++) {
							int num = game(i, j, d);
							if (num > maxV)
								maxV = num;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + maxV);
//			int num = game(0, 4, 1);

		}
	}

	static int game(int sr, int sc, int direction) {
		int cnt = 0;
		int r = sr;
		int c = sc;

		while (true) {
			int nr = r + dr[direction];
			int nc = c + dc[direction];
//			System.out.println(r + " " + c + " " + direction);

			if (nr < 0 || nr >= N || nc < 0 || nc >= N) {
				direction = (direction + 2) % 4; // 반대 방향
				r = nr;
				c = nc;
				cnt++;
			}

			else if (grid[nr][nc] == 0) {
				r = nr;
				c = nc;
			}

			else if (grid[nr][nc] == 1) {
				r = nr;
				c = nc; // 이동
				cnt++;
				if (direction == 1 || direction == 0) // 우 상
					direction = (direction + 2) % 4; // 반대 방향
				else if (direction == 3) // 좌 -> 상
					direction = 0;
				else { // 하 -> 우
					direction = 1;
				}

			}

			else if (grid[nr][nc] == 2) {
				r = nr;
				c = nc; // 이동
				cnt++;
				if (direction == 1 || direction == 2) // 우 하
					direction = (direction + 2) % 4; // 반대 방향
				else if (direction == 0) // 상 -> 우
					direction = 1;
				else { // 좌 -> 하
					direction = 2;
				}

			} else if (grid[nr][nc] == 3) {
				r = nr;
				c = nc; // 이동
				cnt++;
				if (direction == 2 || direction == 3) // 하 좌
					direction = (direction + 2) % 4; // 반대 방향
				else if (direction == 0) // 상 -> 좌
					direction = 3;
				else { // 우 -> 하
					direction = 2;
				}

			} else if (grid[nr][nc] == 4) {
				r = nr;
				c = nc; // 이동
				cnt++;
				if (direction == 3 || direction == 0) // 좌 상
					direction = (direction + 2) % 4; // 반대 방향
				else if (direction == 2) // 하 -> 좌
					direction = 3;
				else { // 우 -> 상
					direction = 0;
				}

			} else if (grid[nr][nc] == 5) {
				r = nr;
				c = nc; // 이동
				cnt++;
				direction = (direction + 2) % 4; // 반대 방향
			}

			else if (grid[nr][nc] == 6) {
				if (nr == warmHole[0][0] && nc == warmHole[0][1]) {
					r = warmHole[0][2];
					c = warmHole[0][3];
				} else {
					r = warmHole[0][0];
					c = warmHole[0][1];
				}
			}

			else if (grid[nr][nc] == 7) {
				if (nr == warmHole[1][0] && nc == warmHole[1][1]) {
					r = warmHole[1][2];
					c = warmHole[1][3];
				} else {
					r = warmHole[1][0];
					c = warmHole[1][1];
				}
			}

			else if (grid[nr][nc] == 8) {
				if (nr == warmHole[2][0] && nc == warmHole[2][1]) {
					r = warmHole[2][2];
					c = warmHole[2][3];
				} else {
					r = warmHole[2][0];
					c = warmHole[2][1];
				}
			}

			else if (grid[nr][nc] == 9) {
				if (nr == warmHole[3][0] && nc == warmHole[3][1]) {
					r = warmHole[3][2];
					c = warmHole[3][3];
				} else {
					r = warmHole[3][0];
					c = warmHole[3][1];
				}
			}

			else if (grid[nr][nc] == 10) {
				if (nr == warmHole[4][0] && nc == warmHole[4][1]) {
					r = warmHole[4][2];
					c = warmHole[4][3];
				} else {
					r = warmHole[4][0];
					c = warmHole[4][1];
				}
			}

			else if (grid[nr][nc] == -1) {
				return cnt;
			}

			if (r == sr && c == sc) {
				return cnt;
			}
		}

	}
}
