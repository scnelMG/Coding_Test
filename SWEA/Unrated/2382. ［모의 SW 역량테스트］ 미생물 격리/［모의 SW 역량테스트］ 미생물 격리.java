import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	static int[] dr = { 0, -1, 1, 0, 0 }; // 상:1, 하:2, 좌:3, 우:4
	static int[] dc = { 0, 0, 0, -1, 1 };
	static int N, M, K;
	static int[][][] grid;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine().trim());

		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());

			grid = new int[N][N][2];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int r = Integer.parseInt(st.nextToken()); // 행
				int c = Integer.parseInt(st.nextToken()); // 열
				int num = Integer.parseInt(st.nextToken()); // 미생물 수
				int direction = Integer.parseInt(st.nextToken()); // 방향
				grid[r][c][0] = num;
				grid[r][c][1] = direction;
			}

			solve(); // 이동시키기

			int res = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					res += grid[i][j][0];
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}

	static void solve() {
		for (int time = 0; time < M; time++) {
			int[][][] grid_tmp = new int[N][N][2]; // [][][0]: 합계 마리수, [][][1]: 방향
			int[][] max_val = new int[N][N]; // 해당 칸에 온 미생물 중 단일 최대값 기록

			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (grid[i][j][0] == 0) // 미생물 0개면 패쓰~
						continue;

					int cur_cnt = grid[i][j][0]; // 현재 군집의 미생물 수
					int cur_dir = grid[i][j][1]; // 현재 군집의 방향

					int nr = i + dr[cur_dir]; // 그 다음 갈 격자 좌표
					int nc = j + dc[cur_dir];

					// 1. 약품 구역에 도착
					if (nr == 0 || nc == 0 || nr == N - 1 || nc == N - 1) {
						grid_tmp[nr][nc][0] = cur_cnt / 2;
						// 방향 반전 로직
						if (cur_dir == 1) // 상 -> 하
							grid_tmp[nr][nc][1] = 2;
						else if (cur_dir == 2) // 하 -> 상
							grid_tmp[nr][nc][1] = 1;
						else if (cur_dir == 3) // 좌 -> 우
							grid_tmp[nr][nc][1] = 4;
						else if (cur_dir == 4) // 우 -> 좌
							grid_tmp[nr][nc][1] = 3;
					}

					// 2. 일반 구역에 도착
					else {
						// 현재 이동해온 미생물 군집(cur_cnt)이
						// 이전에 이 칸에 들어온 어떤 군집보다도 크다 걔의 방향으로 설정
						if (cur_cnt > max_val[nr][nc]) {
							max_val[nr][nc] = cur_cnt;
							grid_tmp[nr][nc][1] = cur_dir;
						}
						// 마리수는 계속 누적 합산
						grid_tmp[nr][nc][0] += cur_cnt;
					}
				}
			}
			// 한 턴이 끝나면 grid_tmp를 원본 grid로 복사
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					grid[i][j][0] = grid_tmp[i][j][0];
					grid[i][j][1] = grid_tmp[i][j][1];
				}
			}
		}
	}
}