import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static boolean[][] visited;
	static int[][] grid;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 터널 타입에 따른 이동 가능 방향 저장 배열
	static int[][] dirs = { {}, { 0, 1, 2, 3 }, { 0, 1 }, { 2, 3 }, { 0, 3 }, { 1, 3 }, { 1, 2 }, { 0, 2 } };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 세로
			int M = Integer.parseInt(st.nextToken()); // 가로
			int R = Integer.parseInt(st.nextToken()); // 출발 위치 행
			int C = Integer.parseInt(st.nextToken()); // 출발 위치 열
			int L = Integer.parseInt(st.nextToken()); // 경과 시간

			grid = new int[N][M]; // 통로 정보 저장 배열
			visited = new boolean[N][M]; // 방문 여부 확인 배열

			for (int i = 0; i < N; i++) { // 통로 정보 받기
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < M; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			Queue<int[]> q = new ArrayDeque<>();
			q.add(new int[] { R, C }); // 시작 위치 add
			visited[R][C] = true; // 방문 처리
			int cnt = 1; // 시작부분 cnt 처리

			for (int i = 1; i < L; i++) { // 시작 부분 방문한 것도 한시간 경과로 침
				// L시간 까지 반복
				if (q.isEmpty()) // 큐가 비어있으면 그만
					break;
				int size = q.size(); // 큐 사이즈 저장 -> 해당 시점의 큐에 들어있는 개수만큼만 탐색
				// -> 각 시간 별로 탐색해야하는게 뭔지 알 수 있음
				for (int j = 0; j < size; j++) {
					int[] cur = q.poll();
					int dir = grid[cur[0]][cur[1]];
					for (int d : dirs[dir]) { // 현재 방문한 터널의 종류에 따라, 갈 수 있는 방향을 탐색
						int nr = cur[0] + dr[d];
						int nc = cur[1] + dc[d];

						if (nr < 0 || nc < 0 || nr >= N || nc >= M) // 범위 벗어나면 continue
							continue;
						if (visited[nr][nc] || grid[nr][nc] == 0) // 이미 방문했거나, 통로가 아니면(0) continue
							continue;

						boolean isCon = false; // 다음으로 갈 통로가 현재 시점 통로랑 연결이 되어 있는지 확인
						for (int nd : dirs[grid[nr][nc]]) {
							// 다음에 방문할 통로가 가능한 방향(nd)랑 내가 방문하려고 하는 방향이 반대여야함
							// 상 -> 하 / 하 -> 상 / 좌 -> 우 / 우 -> 좌
							if ((d == 0 && nd == 1) || (d == 1 && nd == 0) || (d == 2 && nd == 3)
									|| (d == 3 && nd == 2)) {
								isCon = true; // 반대이면 연결되어 있다!
								break; // 하나라도 연결되어 있으면 괜찮음!
							}

						}
						if (!isCon) // 연결 안되어 있으면 continue
							continue;

						q.add(new int[] { nr, nc }); // 다음 통로 좌표를 큐에 넣음
						visited[nr][nc] = true; // 방문 처리
						cnt++; // 방문한 통로 +1

					}

				}

			}
			System.out.println("#" + tc + " " + cnt);

		}
	}

}