import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int[][] adjArr = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjArr[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			int minV = Integer.MAX_VALUE;
			for (int i = 0; i < N; i++) {
				Queue<Integer> q = new ArrayDeque<>();
				boolean[] visited = new boolean[N];

				int dist = 1;
				int total = 0;

				q.offer(i);
				visited[i] = true;

				while (!q.isEmpty()) {
					int size = q.size();
					for (int j = 0; j < size; j++) {
						int cur = q.poll();
						for (int k = 0; k < N; k++) {
							if (!visited[k] && adjArr[cur][k] == 1) {
								visited[k] = true;
								total += dist;
								q.offer(k);
							}
						}
					}
					dist++;
				}

				minV = Math.min(minV, total);
			}

			System.out.println("#" + tc + " " + minV);

		}
	}
}