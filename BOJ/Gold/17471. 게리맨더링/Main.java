import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Main {
	static int N; // 구역 개수
	static boolean[] group; // A, B 구역 나누는 boolean 배열
	static int[][] adjArr; // 인접 배열

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		int[] peoples = new int[N]; // 인구 수 저장 배열
		adjArr = new int[N][N]; // 인접 배열

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			peoples[i] = Integer.parseInt(st.nextToken()); // 인구수 배열에 인구수 저장
		}

		for (int i = 0; i < N; i++) { // 구역 별 연결 정보 저장
			st = new StringTokenizer(br.readLine());
			int cnt = Integer.parseInt(st.nextToken());
			for (int j = 0; j < cnt; j++) {
				int connect = Integer.parseInt(st.nextToken());
				adjArr[i][connect - 1] = 1;
				adjArr[connect - 1][i] = 1;
			}
		}

		int minV = Integer.MAX_VALUE; // 최소 인구수 차이를 저장하는 변수

		for (int i = 1; i < (1 << N) - 1; i++) { // 비트 마스킹으로 전체 경우의 수 구하기 -> 단, 모두 A구역이거나 모두 B구역인 경우는 제외
			group = new boolean[N]; // A, B 구역 나누는 boolean 배열

			for (int j = 0; j < N; j++) { // 각 경우의 수 에 해당하는 구역을 지정 -> 1번 지역은 A구역, 2번 지역은 B구역 이런식으로
				if ((i & (1 << j)) != 0) {
					group[j] = true;
				}
			}

			// 지정된 구역에 대해서 연결 여부 확인
			if (isConnect(true) && isConnect(false)) { // A구역 B구역 다 연결되어 있으면
				// 각 구역별로 인구 수 구함
				int sumA = 0;
				int sumB = 0;

				for (int j = 0; j < N; j++) {
					if (group[j])
						sumA += peoples[j];
					else
						sumB += peoples[j];
				}

				// 최소 차이 인구수 갱신
				if (minV > Math.abs(sumA - sumB))
					minV = Math.abs(sumA - sumB);
			}
		}

		// 모든 경우의 수가 끝남

		if (minV == Integer.MAX_VALUE) // 끝났는데도 갱신 안됨 -> 두 선거구로 나눌 수 없음 -> -1 출력
			System.out.println(-1);
		else { // 연결 되면 최소 인구수 차이값 출력
			System.out.println(minV);
		}
	}

	// 구역이 연결되어있는지 확인하는 함수
	static boolean isConnect(boolean target) {
		// 그래프를 쭉 탐색해 나가면서, 연결된 개수를 셈 -> 그 개수가 해당 구역의 지역 개수와 같으면 다 연결됨!

		// BFS 사용
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N];

		int start = -1;
		int area = 0;

		// 시작점 찾기 -> target(T/F 값)이 처음 나오는 지역을 찾음
		// 시작점 찾으면서 해당 구역의 지역 개수도 area에 저장ㄴ
		for (int i = 0; i < N; i++) {
			if (group[i] == target) {
				if (start == -1)
					start = i;
				area++;
			}
		}

		// BFS 시작
		q.add(start);
		visited[start] = true;
		int areaTmp = 1;

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next = 0; next < N; next++) {
				// 1. 다음이 target 구역에 해당하고
				// 2. 현재 지점과 연결 되어 있으며
				// 3. 방문한적이 없어야 다음으로 진행
				if (group[next] == target && adjArr[cur][next] == 1 && !visited[next]) {
					q.add(next);
					visited[next] = true;
					areaTmp++;
				}
			}
		}

		// 실제 구역의 넓이랑, 연결된 구역의 넓이가 같으면 true
		// 다르면 false
		return area == areaTmp;

	}
}
