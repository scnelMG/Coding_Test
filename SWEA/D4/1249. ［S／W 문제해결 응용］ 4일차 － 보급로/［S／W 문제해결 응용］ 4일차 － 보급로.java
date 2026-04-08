import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

class Solution {
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] grid = new int[N][N];
			int[][] minDist = new int[N][N];

			for (int i = 0; i < N; i++) {
				String tmp = br.readLine();
				for (int j = 0; j < N; j++) {
					grid[i][j] = tmp.charAt(j) - '0';
					minDist[i][j] = Integer.MAX_VALUE;
				}
			}

			// 2 인덱스의 값으로 정렬
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
			minDist[0][0] = 0;
			pq.offer(new int[] { 0, 0, 0 });

			// PQ로 구현
			while (!pq.isEmpty()) {
				int[] cur = pq.poll();
				int r = cur[0];
				int c = cur[1];
				int dist = cur[2];

				// 종료 조건
				if (r == N - 1 && c == N - 1) {
					System.out.println("#" + tc + " " + dist);
					break;
				}

				// 큐에서 꺼낸 거리가, 이미 최소 비용보다 크면 무시
				if (dist > minDist[r][c])
					continue;

				// 네방향 탐색
				for (int d = 0; d < 4; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];

					// 범위 체크
					if (nr < 0 || nc < 0 || nr >= N || nc >= N)
						continue;

					// 다음까지 진행했을 때의 누적 거리 = 현재 누적 거리 + 다음 진행 시 거리
					int nextDist = dist + grid[nr][nc];

					// 다음 누적 거리가 이미 해당 위치의 거리보다 작으면
					if (nextDist < minDist[nr][nc]) {
						minDist[nr][nc] = nextDist; // 최소값 갱신
						pq.offer(new int[] { nr, nc, nextDist }); // pq에 넣기
					}
				}

			}

		}
	}
}