import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine()); 
			int N = Integer.parseInt(st.nextToken()); // 전체 노드 개수 입력
			int[][] adjArr = new int[N][N]; // 인접배열로 노드 간 관계 저장 -> 입력되는 형식이 인접배열에 적합
            
            // 노드 간 관계 저장
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					adjArr[i][j] = Integer.parseInt(st.nextToken()); // 1이면 연결, 0이면 비연결
				}
			}

			int minV = Integer.MAX_VALUE; // 최소값 초기화
            
            // 모든 노드에 대해서 BFS 진행
			for (int i = 0; i < N; i++) {
				Queue<Integer> q = new ArrayDeque<>(); // BFS에 쓸 큐
				boolean[] visited = new boolean[N]; // 방문 처리를 위한 boolean 배열

				int dist = 1; // 거리 변수
				int total = 0; // cc를 구하기 위한 변수 -> 노드에서 다른 노드들 간의 거리를 합하는 변수

				q.offer(i); // 시작 노드를 큐에 넣기
				visited[i] = true; // 방문처리

                // 거리를 구하기 위해 각 레벨별 BFS를 사용
                // 각 레벨이 거리가 됨
				while (!q.isEmpty()) {
					int size = q.size(); // 현재 큐에 들어와 있는 개수를 셈 -> 이걸 안하면 몇번째(거리가 몇인지)에 들어온 노드인지 모름
					for (int j = 0; j < size; j++) { // 현재 들어와 있는 노드 개수 만큼 반복
						int cur = q.poll(); // 큐에서 하나 꺼냄
						for (int k = 0; k < N; k++) { 
							if (!visited[k] && adjArr[cur][k] == 1) { // 그 꺼낸 노드와 연결된 노드이면서 방문을 안했으면
								visited[k] = true; // 방문 처리하고
								total += dist; // 연결된 노드와의 거리를 저장
								q.offer(k); // 연결된 노드를 큐에 넣음
							}
						}
					}
					dist++; // 다음 거리로 
				}

				minV = Math.min(minV, total); // cc 최소값 갱신
			}

			System.out.println("#" + tc + " " + minV);

		}
	}
}