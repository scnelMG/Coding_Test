import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[][] board;
	static ArrayList<int[]> cctvs = new ArrayList<>(); // {r,c,type}
	static int ans = Integer.MAX_VALUE;

	// 상 우 하 좌
	static int[] dr = { -1, 0, 1, 0 };
	static int[] dc = { 0, 1, 0, -1 };

	// 타입별 가능한 방향 세트
	static int[][][] dirs = { {}, // 0 dummy
			{ { 0 }, { 1 }, { 2 }, { 3 } }, // 1
			{ { 0, 2 }, { 1, 3 } }, // 2
			{ { 0, 1 }, { 1, 2 }, { 2, 3 }, { 3, 0 } }, // 3
			{ { 0, 1, 2 }, { 1, 2, 3 }, { 2, 3, 0 }, { 3, 0, 1 } }, // 4
			{ { 0, 1, 2, 3 } } // 5
	};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (1 <= board[i][j] && board[i][j] <= 5) {
					cctvs.add(new int[] { i, j, board[i][j] });
				}
			}
		}

		dfs(0, board);
		System.out.println(ans);
	}

	static void dfs(int idx, int[][] map) {
		if (idx == cctvs.size()) {
			ans = Math.min(ans, countZero(map));
			return;
		}

		int[] cam = cctvs.get(idx);
		int r = cam[0], c = cam[1], type = cam[2];

		for (int i = 0; i < dirs[type].length; i++) {
			int[][] next = copyMap(map);
			for (int j = 0; j < dirs[type][i].length; j++) {
				watch(next, r, c, dirs[type][i][j]);
			}
			dfs(idx + 1, next);
		}
	}

	static void watch(int[][] map, int r, int c, int d) {
		int nr = r, nc = c;
		while (true) {
			nr += dr[d];
			nc += dc[d];
			if (nr < 0 || nc < 0 || nr >= N || nc >= M)
				break;
			if (map[nr][nc] == 6)
				break; // 벽에서 stop
			if (map[nr][nc] == 0)
				map[nr][nc] = -1; // 빈칸만 감시표시
		}
	}

	static int countZero(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					cnt++;
			}
		}
		return cnt;
	}

	static int[][] copyMap(int[][] src) {
		int[][] dst = new int[N][M];
		for (int i = 0; i < N; i++) {
			System.arraycopy(src[i], 0, dst[i], 0, M);
		}
		return dst;
	}
}