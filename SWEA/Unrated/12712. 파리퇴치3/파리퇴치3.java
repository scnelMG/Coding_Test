import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr1 = { -1, 1, 0, 0 };
	static int[] dc1 = { 0, 0, -1, 1 };
	static int[] dr2 = { -1, -1, 1, 1 };
	static int[] dc2 = { -1, 1, 1, -1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int[][] grid = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int maxV = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					int sum = grid[i][j];
					for (int d = 0; d < 4; d++) {
						for (int len = 1; len < M; len++) {
							int nr = i + len * dr1[d];
							int nc = j + len * dc1[d];

							if (nr < 0 || nc < 0 || nr >= N || nc >= N)
								break;

							sum += grid[nr][nc];

						}
					}
					maxV = Math.max(maxV, sum);
					sum = grid[i][j];
					for (int d = 0; d < 4; d++) {
						for (int len = 1; len < M; len++) {
							int nr = i + len * dr2[d];
							int nc = j + len * dc2[d];

							if (nr < 0 || nc < 0 || nr >= N || nc >= N)
								break;

							sum += grid[nr][nc];

						}
					}
					maxV = Math.max(maxV, sum);
				}
			}

			System.out.println("#" + tc + " " + maxV);

		}
	}
}
