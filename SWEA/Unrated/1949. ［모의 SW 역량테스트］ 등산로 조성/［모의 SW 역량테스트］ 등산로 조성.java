import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {

	static int N, K, ans;
	static boolean[][] visited;
	static int[][] grid;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			grid = new int[N][N];
			int maxV = 0;
			ans = 0;
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					if (grid[i][j] > maxV)
						maxV = grid[i][j];
				}
			}

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (grid[i][j] == maxV) {
						work(i, j, 1, false);
					}
				}
			}
			System.out.println("#" + tc + " " + ans);
		}
	}

	static void work(int r, int c, int dist, boolean flag) {
		if (dist > ans)
			ans = dist;
		visited[r][c] = true; // 경로에 포함시킴

		// 4방향 탐색을 통해 등산로 조성
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= N || nc >= N || visited[nr][nc])
				continue;

			// 다음 좌표의 높이가 현재 나의 높이보다 낮다면.. (그냥 go)
			if (grid[r][c] > grid[nr][nc]) {
				work(nr, nc, dist + 1, flag);
			}

			// 다음 좌표의 높이가 현재 나의 높이와 같거나 높다면 (공사 가능인지 파악)
			else if (!flag && grid[r][c] > grid[nr][nc] - K) {
				int tmp = grid[nr][nc];
				grid[nr][nc] = grid[r][c] - 1;
				work(nr, nc, dist + 1, true);
				grid[nr][nc] = tmp;
			}
		}

		visited[r][c] = false;

	}
}