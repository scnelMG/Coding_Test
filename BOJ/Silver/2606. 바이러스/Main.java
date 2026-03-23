import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int comNum = Integer.parseInt(br.readLine());

		int[][] adjArr = new int[N + 1][N + 1];
		boolean[] visited = new boolean[N + 1];

		for (int i = 0; i < comNum; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			adjArr[a][b] = 1;
			adjArr[b][a] = 1;
		}

		Queue<Integer> q = new ArrayDeque<>();
		q.add(1);
		visited[1] = true;

		int cnt = 0;

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 1; i <= N; i++) {
				// 4. 연결되어 있고(1) + 아직 방문하지 않았다면(!visited)
				if (adjArr[cur][i] == 1 && !visited[i]) {
					visited[i] = true;
					q.add(i);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}