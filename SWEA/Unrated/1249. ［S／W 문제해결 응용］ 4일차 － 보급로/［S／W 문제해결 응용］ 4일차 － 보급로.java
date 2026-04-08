import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] grid = new int[N][N];
			int[][] minDist = new int[N][N];
			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < N; j++) {
					grid[i][j] = tmp.charAt(j) - '0';
					minDist[i][j] = Integer.MAX_VALUE;
				}
			}

			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] { 0, 0 });
			minDist[0][0] = grid[0][0];

			while (!q.isEmpty()) {
				int[] cur = q.poll();
				int r = cur[0];
				int c = cur[1];

				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;

					int nextDist = minDist[r][c] + grid[nr][nc];
					if (nextDist < minDist[nr][nc]) {
						minDist[nr][nc] = nextDist;
						q.offer(new int[] { nr, nc });
					}
				}

			}
			System.out.println("#" + tc + " " + minDist[N - 1][N - 1]);

		}
	}
}