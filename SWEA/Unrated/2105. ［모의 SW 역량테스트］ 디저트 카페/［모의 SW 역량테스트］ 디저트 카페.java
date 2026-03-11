import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Solution {
	static int N;
	static int[][] grid;
	static int maxV;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for (int tc = 1; tc <= T; tc++) {
			N = Integer.parseInt(br.readLine());
			grid = new int[N][N];

			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					grid[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			maxV = -1;
			// 1 ~ N-2
			for (int rLen = 1; rLen <= N - 2; rLen++) {
				for (int cLen = 1; cLen <= N - 2; cLen++) {
					if (rLen + cLen < N)
						make(rLen, cLen); // 길이에 맞게 사각형 만들기
				}
			}
			System.out.println("#" + tc + " " + maxV);

		}
	}

	// 길이를 입력 받고 사각형 만들기
	static void make(int rLen, int cLen) {
		for (int r = 0; r < N - (rLen + cLen); r++) {
			for (int c = cLen; c <= N - rLen - 1; c++) {
				// 길이(rLen, cLen)와 출발 위치(r, c)를 받고 직접 방문해서 디저트 개수 세기
				int num = visited(rLen, cLen, r, c);
				if (num > maxV)
					maxV = num;
			}
		}
	}

	// 사각형 경로를 다 지나가면서 디저트 먹기
	static int visited(int rLen, int cLen, int r, int c) {
		List<Integer> list = new ArrayList<>(); // 먹은 디저트 저장

		for (int i = 1; i <= rLen; i++) { // 오른쪽 아래 대각선
			if (list.contains(grid[r + i][c + i])) { // list에 담겨 있으면 더이상 확인할 필요가 없음 -> return
				return -1;
			}
			list.add(grid[r + i][c + i]);
		}
		r += rLen;
		c += rLen;

		for (int i = 1; i <= cLen; i++) { // 왼쪽 아래 대각선
			if (list.contains(grid[r + i][c - i])) {
				return -1;
			}
			list.add(grid[r + i][c - i]);
		}
		r += cLen;
		c -= cLen;

		for (int i = 1; i <= rLen; i++) { // 왼쪽 위 대각선
			if (list.contains(grid[r - i][c - i])) {
				return -1;
			}
			list.add(grid[r - i][c - i]);
		}
		r -= rLen;
		c -= rLen;

		for (int i = 1; i <= cLen; i++) { // 오른쪽 위 대각선
			if (list.contains(grid[r - i][c + i])) {
				return -1;
			}
			list.add(grid[r - i][c + i]);
		}
		r -= cLen;
		c += cLen;

		return list.size();

	}
}