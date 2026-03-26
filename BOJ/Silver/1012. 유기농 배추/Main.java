import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] grid;
	static int N, M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());

		for (int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			grid = new int[N][M];

			for (int k = 0; k < K; k++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				grid[r][c] = 1;
			}

			int cnt = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < M; j++) {
					if (grid[i][j] == 1) {
						draw(i, j);
						cnt++;
					}

				}
			}

			System.out.println(cnt);
		}

	}

	static void draw(int i, int j) {
		grid[i][j] = 2;

		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				continue;
			if (grid[nr][nc] == 1) {
				draw(nr, nc);
			}
		}

	}
}
