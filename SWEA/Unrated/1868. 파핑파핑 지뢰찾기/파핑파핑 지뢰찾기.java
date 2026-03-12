import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static char[][] grid;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0, -1, -1, 1, 1 }; // 상하좌우, 왼쪽위, 오른쪽 위, 왼쪽 아래, 오른쪽 아래
	static int[] dc = { 0, 0, -1, 1, -1, 1, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 개수

		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine()); // 격자 크기

			grid = new char[N][N]; // 폭단 정보 담은 char 배열
			visited = new boolean[N][N]; // 방문 정보 담을 boolean 배열
			int[][] bombs = new int[N][N]; // 주변 폭단 개수 담을 int 배열

			for (int i = 0; i < N; i++) { // 폭단 정보 입력받기
				grid[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < N; i++) { // 주변 폭단 개수 세기
				for (int j = 0; j < N; j++) {
					if (grid[i][j] == '*') // 폭탄이면 -1로 표시
						bombs[i][j] = -1;
					else {
						bombs[i][j] = findBomb(i, j); // 8방향의 폭단 개수 저장
					}
				}
			}

			int cnt = 0; // 클릭 횟수 초기화
			
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (bombs[i][j] == 0 && !visited[i][j]) { // 주변에 폭단이 없고, 방문 안했을 때
						cnt++; // 클릭 
						
						// bfs로 주변 연쇄작용
						Queue<int[]> q = new ArrayDeque<>();
						q.add(new int[] { i, j });
						visited[i][j] = true;

						while (!q.isEmpty()) {
							int[] cur = q.poll();

							if (bombs[cur[0]][cur[1]] == 0) { // 큐에서 꺼낸 좌표에서 폭탄이 없을 때만 연쇄 진행
								for (int d = 0; d < 8; d++) { // 8방향 탐색
									int nr = cur[0] + dr[d];
									int nc = cur[1] + dc[d];
									if (nr < 0 || nc < 0 || nr >= N || nc >= N) // 격자 범위 벗어나면 continue
										continue;
									if (bombs[nr][nc] == -1 || visited[nr][nc]) // 폭탄이거나 방문했으면 continue
										continue;
									// 연쇄작용을 위해서 큐에 담기
									q.add(new int[] { nr, nc });
									visited[nr][nc] = true;
								}
							}
						}
					}
				}
			}
			// 연쇄작용으로 처리가 안된 빈칸 세기
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (bombs[i][j] != -1 && !visited[i][j]) // 폭탄이 아니고 방문을 안했으면 개수 세기
						cnt++;
				}
			}
			System.out.println("#" + tc + " " + cnt);

		}
	}

	static int findBomb(int i, int j) { // 8방향 탐색으로 폭탄 개수 세기
		int cnt = 0;
		for (int d = 0; d < 8; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= N)
				continue;
			if (grid[nr][nc] == '*')
				cnt++;
		}
		return cnt;
	}

}