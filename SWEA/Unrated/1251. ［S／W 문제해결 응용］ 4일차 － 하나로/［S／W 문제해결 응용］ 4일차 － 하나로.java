import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			long[] x = new long[N];
			long[] y = new long[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				x[i] = Long.parseLong(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				y[i] = Long.parseLong(st.nextToken());
			}

			double E = Double.parseDouble(br.readLine());

			long[] dist = new long[N];
			Arrays.fill(dist, Long.MAX_VALUE);
			dist[0] = 0;
			boolean[] visited = new boolean[N];
			long ans = 0;

			for (int i = 0; i < N; i++) {
				long min = Long.MAX_VALUE;
				int idx = -1;
				for (int j = 0; j < N; j++) {
					if (!visited[j] && dist[j] < min) {
						idx = j;
						min = dist[j];
					}
				}

				visited[idx] = true;
				ans += dist[idx];

				for (int j = 0; j < N; j++) {
					if (!visited[j]) {
						long d = (x[idx] - x[j]) * (x[idx] - x[j]) + (y[idx] - y[j]) * (y[idx] - y[j]);

						if (dist[j] > d)
							dist[j] = d;
					}
				}

			}
			ans = Math.round(ans * E);
			System.out.println("#" + tc + " " + ans);

		}
	}
}