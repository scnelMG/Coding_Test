import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	static int N, minV;
	static int[][] dist;
	static int[] res;
	static boolean[] visited;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수 입력 받기
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 방문할 도시 개수 입력 받기
			minV = Integer.MAX_VALUE; // 최소 거리 저장 변수
			dist = new int[N + 2][2]; // 방문할 도시 + 회사, 집의 좌표 저장하는 이차원 배열 (배결 크기 N+2, 2)
			res = new int[N]; // 순열 결과 저장하는 배열
			visited = new boolean[N]; // 방문 여부 저장하는 배열

			StringTokenizer st = new StringTokenizer(br.readLine());

			for (int i = 0; i < N + 2; i++) { // 방문할 도시 + 회사, 집의 좌표 좌표 저장
				dist[i][0] = Integer.parseInt(st.nextToken());
				dist[i][1] = Integer.parseInt(st.nextToken());
			}

			perm(0);
			System.out.println("#" + tc + " " + minV);
		}
	}

	// 멘하탄 거리 계산하는 함수
	static int calDist(int a, int b) {
		return Math.abs(dist[a][0] - dist[b][0]) + Math.abs(dist[a][1] - dist[b][1]);
	}

	// 순열 선택하는 함수 + 이동 거리 계산
	static void perm(int idx) {
		if (idx == N) { // 전부다 방문!
			int total = 0; // 이동 거리 저장하는 변수

			total += calDist(0, res[0]); // 직장 -> 첫 도시까지의 거리
			for (int i = 0; i < N - 1; i++) { // 도시간의 방문
				total += calDist(res[i], res[i + 1]);
			}
			total += calDist(res[N - 1], 1); // 마지막 도시 -> 집까지의 거리

			if (total < minV) // 최소 거리 갱신ㄴ
				minV = total;
			return;
		}

		for (int i = 0; i < N; i++) {
			if (visited[i]) { // 방문 했으면 해당 도시 더이상 방문 안함
				continue;
			}

			res[idx] = i + 2; // 도시의 인덱스 저장 (dist 이차원 배열에서 앞에 직장, 도시가 있으므로 인덱스 2부터 시작)
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false; // 원상 복구
		}

	}
}
