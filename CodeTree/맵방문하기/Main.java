package 박민규.CodeTree.맵방문하기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		char[][] grid = new char[N][M];
		char[] arr = { 'L', 'R', 'U', 'D' }; // 가능한 입력값들

		int res = 0;

		for (int i = 0; i < N; i++) {
			String tmp = sc.next();
			for (int j = 0; j < M; j++) {
				grid[i][j] = tmp.charAt(j);
			}
		}

		// 1. 마법 사용 안 함
		res = Math.max(res, findVisit(grid));

		// 2. 행(Row) 마법 적용
		for (int i = 0; i < N; i++) {
			for (int c = 0; c < arr.length; c++) {
				char[][] grid2 = new char[N][M];

				for (int k = 0; k < N; k++) { // 깊은복사
					grid2[k] = grid[k].clone();
				}

				for (int j = 0; j < M; j++) {
					grid2[i][j] = arr[c]; // 마법 부리기
				}
				res = Math.max(res, findVisit(grid2));
			}
		}

		// 3. 열(Column) 마법 적용
		for (int j = 0; j < M; j++) {
			for (int c = 0; c < arr.length; c++) {
				char[][] grid2 = new char[N][M];
				for (int k = 0; k < N; k++) { // 깊은복사
					grid2[k] = grid[k].clone();
				}
				for (int i = 0; i < N; i++) { // 마법 부리기
					grid2[i][j] = arr[c];
				}
				res = Math.max(res, findVisit(grid2));
			}
		}

		System.out.println(res);
	}

	static int findVisit(char[][] grid) {
		int max_v = 0;
		int R = grid.length;
		int C = grid[0].length;

		// [최적화] 방문 배열을 루프 밖에서 한 번만 생성
		int[][] visitArr = new int[R][C];
		int trial = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				trial++; // 방문 체크용 고유값
				int cnt = 0;
				int s_r = i;
				int s_c = j;

				while (true) {
					// 현재 위치 방문 체크
					if (visitArr[s_r][s_c] == trial)
						break;
					visitArr[s_r][s_c] = trial;
					cnt++; // 현재 위치 방문

					// 이동 방향 결정
					char d = grid[s_r][s_c];
					if (d == 'U')
						s_r--;
					else if (d == 'D')
						s_r++;
					else if (d == 'L')
						s_c--;
					else if (d == 'R')
						s_c++;

					// 격자 밖으로 나가는지 확인
					if (s_r < 0 || s_r >= R || s_c < 0 || s_c >= C)
						break;
				}
				if (cnt > max_v)
					max_v = cnt;
			}
		}
		return max_v;
	}
}