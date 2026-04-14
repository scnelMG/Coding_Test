import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int[][] grid;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		grid = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int time = 0;
		while (true) {
			if (isDisappear()) {
				System.out.println(0);
				break;
			}
			if (isSeperate()) {
				System.out.println(time);
				break;
			}
			melt();
			time++;
		}

	}

	private static void melt() {
		int[][] tmp_grid = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				tmp_grid[i][j] = grid[i][j];
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (tmp_grid[i][j] != 0) {
					int waterCnt = 0;
					for (int d = 0; d < 4; d++) {
						int nr = i + dr[d];
						int nc = j + dc[d];
						if (nr < 0 || nc < 0 || nr >= N || nc >= M)
							continue;
						if (tmp_grid[nr][nc] == 0)
							waterCnt++;
					}
					grid[i][j] = tmp_grid[i][j] - waterCnt;
					if (grid[i][j] < 0)
						grid[i][j] = 0;
				}
			}
		}

	}

	private static boolean isSeperate() {
		boolean[][] visited = new boolean[N][M];

		int iceCnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] != 0) {
					iceCnt++;
				}
			}
		}

		int si = -1;
		int sj = -1;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] != 0) {
					si = i;
					sj = j;
					break;
				}
			}
		}

		Queue<int[]> q = new ArrayDeque<>();
		q.add(new int[] { si, sj });
		visited[si][sj] = true;
		int connectCnt = 1;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int r = cur[0];
			int c = cur[1];
			for (int d = 0; d < 4; d++) {
				int nr = r + dr[d];
				int nc = c + dc[d];

				if (nr < 0 || nc < 0 || nr >= N || nc >= M || visited[nr][nc] || grid[nr][nc] == 0) {
					continue;
				}
				q.add(new int[] { nr, nc });
				visited[nr][nc] = true;
				connectCnt++;
			}
		}

		return connectCnt != iceCnt;
	}

	private static boolean isDisappear() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (grid[i][j] != 0) {
					return false;
				}
			}
		}
		return true;
	}
}
