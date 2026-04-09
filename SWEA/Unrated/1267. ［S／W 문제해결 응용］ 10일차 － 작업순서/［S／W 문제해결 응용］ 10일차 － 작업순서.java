import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int tc = 1; tc <= 10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
            
            // 인접 배열 생성
			int[][] adjArr = new int[V + 1][V + 1];
            
            // 진입차수 저장 배열 저장
			int[] inDegree = new int[V + 1];
            
            // 간선 정보 저장
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < E; i++) {
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());

				adjArr[from][to] = 1; // 연결 정보 저장
				inDegree[to]++; // 진입차수 추가
			}

			Queue<Integer> q = new ArrayDeque<>();
			StringBuilder sb = new StringBuilder(); // 결과 저장 
			sb.append("#" + tc + " ");
            
            // 진입 차수가 0인 애들 q에 넣음
			for (int i = 1; i <= V; i++) {
				if (inDegree[i] == 0)
					q.add(i);
			}

            // q가 빌 때까지
			while (!q.isEmpty()) {
				int cur = q.poll(); // 노드 꺼내고
				sb.append(cur + " ");
				for (int i = 1; i <= V; i++) {
					if (adjArr[cur][i] == 1) { // 그 노드에 연결되어 있는 애들에 대해서
						inDegree[i]--; //  연결을 끊음
						if (inDegree[i] == 0) { // 진입차수가 0이면 해당 노드도 q에 넣음
							q.add(i);
						}
					}
				}
			}
			
			System.out.println(sb);
		}
	}

}
