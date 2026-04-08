import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;

class Solution {

	// 방문 체크용 전역 배열 (배열을 계속 새로 만들지 않기 위함)
	static int[] visited;
	static int visitToken = 0;

	public static void main(String[] args) throws Exception {
		// Scanner 대신 훨씬 빠른 BufferedReader 사용
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int M = Integer.parseInt(br.readLine());

			// List 인터페이스 대신 구체 클래스 ArrayList로 직접 선언
			ArrayList<Integer>[] adjList = new ArrayList[N + 1];
			ArrayList<Integer>[] adjListRev = new ArrayList[N + 1];

			// visited 배열은 N 크기에 맞춰 한 번만 생성
			visited = new int[N + 1];

			for (int i = 1; i <= N; i++) {
				adjList[i] = new ArrayList<>();
				adjListRev[i] = new ArrayList<>();
			}

			for (int i = 0; i < M; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				adjList[a].add(b);
				adjListRev[b].add(a);
			}

			int res = 0;
			for (int i = 1; i <= N; i++) {
				// 탐색을 시작할 때마다 고유 토큰 값 증가
				visitToken++;
				int cnt = bfs(i, adjList);

				visitToken++;
				int cntRev = bfs(i, adjListRev);

				if (cnt + cntRev == N - 1) {
					res++;
				}
			}

			System.out.println("#" + tc + " " + res);
		}
	}

	// 파라미터에서 N을 뺐습니다. (배열 재생성을 안 하므로 필요 없어짐)
	static int bfs(int start, ArrayList<Integer>[] arr) {
		ArrayDeque<Integer> q = new ArrayDeque<>();

		// boolean 대신 현재의 visitToken 값을 넣어서 방문 처리
		visited[start] = visitToken;
		q.offer(start); // add() 대신 예외를 던지지 않는 offer() 사용이 더 안전하고 빠름

		int cnt = 0;
		while (!q.isEmpty()) {
			int cur = q.poll(); // remove() 대신 poll()

			for (int next : arr[cur]) {
				// 다음 노드에 적힌 값이 이번 탐색의 토큰 값과 다르면 방문하지 않은 것!
				if (visited[next] != visitToken) {
					visited[next] = visitToken;
					q.offer(next);
					cnt++;
				}
			}
		}

		return cnt;
	}
}