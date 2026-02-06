package 박민규.CodeTree.1이3개이상있는위치;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[][] arr = new int[n][n];

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		int x = 0;
		int y = 0;

		int res = 0; // 결과 저장

		// 2차원 배열에 값 넣기
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = sc.nextInt();
			}
		}

		for (int i = 0; i < n; i++) { // 배열 전체 순회화면서
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int d = 0; d < 4; d++) {
					x = i + dr[d];
					y = j + dc[d];
					if (x < 0 || x >= n || y < 0 || y >= n) { // 배열 범위 밖이면 넘어감
						continue;
					} else if (arr[x][y] == 1) { // 상하좌우에 1이 있으면 cnt 추가
						cnt++;
					}

				}
				if (cnt >= 3) // 주변 1의 개수가 3이상이면 최종 결과 ++
					res++;
			}
		}
		System.out.println(res);

	}
}