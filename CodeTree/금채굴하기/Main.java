package 박민규.CodeTree.금채굴하기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] grid = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				grid[i][j] = sc.nextInt();

		int max_coin = 0;

		for (int k = 0; k <= n; k++) { // 마름모 크기 늘려가기
			int cost = k * k + (k + 1) * (k + 1); // 마름모 비용 계산
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int coin = searchDiamond(grid, i, j, k); // 해당 격자, 마름모 크기에 대해서 얻을 동전 개수
					if (coin * m >= cost && max_coin < coin) // 최대 코인 갱신
						max_coin = coin;
				}
			}
		}
		System.out.println(max_coin);

	}

	public static int searchDiamond(int[][] map, int centerR, int centerC, int K) {
		int N = map.length; // 맵의 크기 (N x N 가정)
		int res = 0;

		// 1. 행(Row) 탐색: 중심에서 위아래로 K만큼
		for (int r = centerR - K; r <= centerR + K; r++) {

			// 2. 맵 범위를 벗어나는 행은 건너뜀
			if (r < 0 || r >= N)
				continue;

			// 3. 현재 행과 중심 행 사이의 거리 계산
			int v_dist = Math.abs(r - centerR);

			// 4. 열(Col) 탐색: 중심 열 기준, (K - 수직거리) 만큼 좌우로 퍼짐
			for (int c = centerC - (K - v_dist); c <= centerC + (K - v_dist); c++) {

				// 5. 맵 범위를 벗어나는 열은 건너뜀
				if (c < 0 || c >= N)
					continue;

				if (map[r][c] == 1)
					res++;
			}
		}
		return res;
	}

}
