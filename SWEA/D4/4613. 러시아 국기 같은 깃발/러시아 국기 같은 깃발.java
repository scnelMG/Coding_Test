import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			char[][] grid = new char[N][M];

			for (int i = 0; i < N; i++) { // char로 입력받아서 배열에 저장
				String s = sc.next();
				for (int j = 0; j < M; j++) {
					grid[i][j] = s.charAt(j);
				}
			}

			// 흰-> 파 바뀌는 순간 (1~N-2)
			// 파 -> 빨 바귀는 순간 (흰-> 파 바뀌는 순간 다음 ~ N-1)
			int min_v = 100000000;
			for (int i = 1; i < N - 1; i++) { // 흰-> 파 바뀌는 순간 : i
				for (int j = i + 1; j < N; j++) { // 파 -> 빨 바귀는 순간 : j
					int cnt = 0; // 바꿔야하는 개수 세기
					for (int w = 0; w < i; w++) { // 흰색 영역
						for (int c = 0; c < M; c++) {
							if (grid[w][c] != 'W')
								cnt++;
						}
					}

					for (int b = i; b < j; b++) { // 파란색 영역
						for (int c = 0; c < M; c++) {
							if (grid[b][c] != 'B')
								cnt++;
						}
					}

					for (int r = j; r < N; r++) { // 빨강색 영역
						for (int c = 0; c < M; c++) {
							if (grid[r][c] != 'R')
								cnt++;
						}
					}

					if (cnt < min_v)
						min_v = cnt;

				}
			}
			System.out.println("#" + tc + " " + min_v);

		}

	}

}
