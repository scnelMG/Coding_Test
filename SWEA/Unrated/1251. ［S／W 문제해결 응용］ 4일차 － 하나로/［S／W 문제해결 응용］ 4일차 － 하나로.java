import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Solution {
	static class Edge implements Comparable<Edge> {
		int to;
		long cost;

		public Edge(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}

		public int compareTo(Edge o) {

			return Long.compare(this.cost, o.cost);
		}

	}

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

			PriorityQueue<Edge> pq = new PriorityQueue<>();
			boolean[] visited = new boolean[N];

			pq.add(new Edge(0, 0));

			long ans = 0;
			int pick = 0;

			while (!pq.isEmpty()) {
				Edge cur = pq.poll();

				if (visited[cur.to])
					continue;

				visited[cur.to] = true;
				ans += cur.cost;
				pick++;

				if (pick == N)
					break;

				for (int i = 0; i < N; i++) {
					if (!visited[i]) {
						long cost = (x[cur.to] - x[i]) * (x[cur.to] - x[i]) + (y[cur.to] - y[i]) * (y[cur.to] - y[i]);
						pq.add(new Edge(i, cost));
					}

				}

			}
			ans = Math.round(ans * E);
			System.out.println("#" + tc + " " + ans);

		}
	}
}