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
	static int[] peoples; // 메서드에서 접근할 수 있도록 전역 변수로 승격

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		peoples = new int[N]; 
		adjArr = new int[N][N];
		
		// 개선 1: 배열 객체를 반복문 밖에서 단 한 번만 생성하여 메모리 낭비 제거
		group = new boolean[N]; 

		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			peoples[i] = Integer.parseInt(st.nextToken()); 
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

		int minV = Integer.MAX_VALUE; 

		// 개선 2: 중복 탐색 제거 (탐색 범위를 N-1 비트까지만 돌려서 정확히 절반으로 줄임)
		// N-1번째 구역(가장 마지막 구역)은 무조건 false(B구역)로 고정되는 마법!
		int limit = 1 << (N - 1);
		for (int i = 1; i < limit; i++) { 
			
			for (int j = 0; j < N; j++) { 
				// 기존 배열 값만 덮어쓰기 재사용
				group[j] = (i & (1 << j)) != 0;
			}

			// 개선 3: BFS 탐색과 인구수 계산을 동시에 처리 (getPopIfConnected)
			int sumA = getPopIfConnected(true);
			
			// A구역이 연결되지 않았다면 더 이상 볼 필요 없이 바로 다음 경우의 수로 패스 (속도 최적화)
			if (sumA == -1) continue; 
			
			int sumB = getPopIfConnected(false);
			
			// B구역도 정상 연결되었다면
			if (sumB != -1) { 
				// 최소 인구수 차이 갱신
				if (minV > Math.abs(sumA - sumB)) {
					minV = Math.abs(sumA - sumB);
				}
			}
		}

		// 출력 처리
		if (minV == Integer.MAX_VALUE) 
			System.out.println(-1);
		else { 
			System.out.println(minV);
		}
	}

	// 구역이 연결되어있는지 확인하면서 연결 시 '인구수'를 반환, 안 되어있으면 '-1' 반환
	static int getPopIfConnected(boolean target) {
		Queue<Integer> q = new ArrayDeque<>();
		boolean[] visited = new boolean[N];

		int start = -1;
		int area = 0;

		for (int i = 0; i < N; i++) {
			if (group[i] == target) {
				if (start == -1)
					start = i;
				area++;
			}
		}

		q.add(start);
		visited[start] = true;
		int areaTmp = 1;
		
		// 시작점의 인구수부터 시작
		int popSum = peoples[start]; 

		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next = 0; next < N; next++) {
				if (group[next] == target && adjArr[cur][next] == 1 && !visited[next]) {
					q.add(next);
					visited[next] = true;
					areaTmp++;
					
					// BFS 탐색을 하면서 다음 구역의 인구수 누적 합산
					popSum += peoples[next]; 
				}
			}
		}

		// 실제 구역 개수랑 연결된 구역 개수가 같으면 정상 연결 -> 누적 인구수 반환
		if (area == areaTmp) {
			return popSum;
		} else {
			return -1; // 하나라도 끊어져 있으면 -1 반환
		}
	}
}