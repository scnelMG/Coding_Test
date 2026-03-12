import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	static int N;
	static boolean[][] isEat;
	static boolean[][] visited;
	static int[][] grid;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			grid = new int[N][N];
			isEat = new boolean[N][N];
			int maxDay = -1; // 최대 일자

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
					if (maxDay < grid[i][j])
						maxDay = grid[i][j];
				}
			}
			int maxV = 1; // 최대 덩어리 개수
			for (int day = 1; day <= maxDay; day++) { // 1~최대 일자까지 반복
				check(day); // 요정이 일단 치즈 먹고
				int num = countLoaf(); // 그에 대해서 덩어리 개수 세기
				if (num > maxV) // 덩어리 최대 개수 갱신
					maxV = num;
			}
			System.out.println("#" + tc + " " + maxV);

		}
	}

	static int countLoaf() { // 덩어리 세는 함수
		visited = new boolean[N][N]; // 방문 했는지 확인하는 배열

		// 요정이 먹은 부분도 방문 하지 못한다고 설정 -> isEat 배열 복사
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				visited[i][j] = isEat[i][j];
			}
		}

		int cnt = 0; // 덩어리 개수 저장 변수
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) { // 전체를 돌면서
				if (visited[i][j] == false) { // 방문 안한 격자 찾기
					cnt++;
					q.add(new int[] { i, j }); // 해당 격자를 출발점으로 설정
					visited[i][j] = true;
					while (!q.isEmpty()) { // bfs 시작
						int[] cur = q.poll();

						for (int d = 0; d < 4; d++) { // 네방향 탐색
							int nr = cur[0] + dr[d];
							int nc = cur[1] + dc[d];

							// 범위 벗어나면 끝
							if (nr < 0 || nc < 0 || nr >= N || nc >= N)
								continue;

							// 이미 방문했으면 끝
							if (visited[nr][nc])
								continue;

							// 큐에 저장
							q.add(new int[] { nr, nc });
							visited[nr][nc] = true;
						}

					}
				}

			}
		}

		return cnt;
	}

	static void check(int day) { // 날짜별로 요정이 먹는 치즈 확인하는 함수
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (grid[i][j] == day) // 해당 날짜에 대한 값을 가지면 -> 요정이 먹는다!
					isEat[i][j] = true;
			}
		}
	}

}