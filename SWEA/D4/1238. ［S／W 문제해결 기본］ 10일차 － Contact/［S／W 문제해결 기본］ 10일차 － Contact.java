import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int len = Integer.parseInt(st.nextToken());
			int start = Integer.parseInt(st.nextToken());

			// 인접리스트로 저장
			List<Integer>[] adjList = new ArrayList[101];
			for (int i = 1; i <= 100; i++) {
				adjList[i] = new ArrayList<>();
			}

			// 연결 정보 저장
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < len / 2; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				adjList[from].add(to);
			}

			// 방문 체크할 때, 깊이를 저장해야함 -> 가장 깊은 번호를 찾아야하기 때문
			int[] visited = new int[101];
			Arrays.fill(visited, -1); // -1로 초기화

			Queue<Integer> q = new ArrayDeque<>();
			q.offer(start);

			int maxV = 0; // 최대 깊이 저장 변수

			while (!q.isEmpty()) {
				int cur = q.poll();

				for (int next : adjList[cur]) {
					if (visited[next] == -1) {
						visited[next] = visited[cur] + 1;
						q.offer(next);
						maxV = Math.max(maxV, visited[next]);
					}
				}
			}

			int ans = 0;
			for (int i = 100; i >= 1; i--) {
				if (visited[i] == maxV) {
					ans = i;
					break;
				}
			}

			System.out.println("#" + tc + " " + ans);

		}

	}
}