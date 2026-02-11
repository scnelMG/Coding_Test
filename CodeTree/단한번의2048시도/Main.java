package 박민규.CodeTree.단한번의2048시도;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] grid = new int[4][4];

		// 입력 받기
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				grid[i][j] = sc.nextInt();
			}
		}
		char dir = sc.next().charAt(0);

		// 각 방향에 따라 로직 수행
		if (dir == 'L') {
			for (int i = 0; i < 4; i++) {
				// 1. 해당 행의 0이 아닌 숫자들을 임시 배열에 담음
				int[] temp = new int[4];
				int idx = 0;
				for (int j = 0; j < 4; j++) {
					if (grid[i][j] != 0) {
						temp[idx++] = grid[i][j];
					}
				}
				// 2. 합치기 로직 (왼쪽부터)
				for (int j = 0; j < 3; j++) {
					if (temp[j] != 0 && temp[j] == temp[j + 1]) {
						temp[j] *= 2;
						temp[j + 1] = 0;
					}
				}
				// 3. 합쳐진 후 다시 앞으로 정렬하여 그리드에 반영
				int[] finalRow = new int[4];
				idx = 0;
				for (int j = 0; j < 4; j++) {
					if (temp[j] != 0)
						finalRow[idx++] = temp[j];
				}
				for (int j = 0; j < 4; j++) {
					grid[i][j] = finalRow[j];
				}
			}
		} else if (dir == 'R') {
			for (int i = 0; i < 4; i++) {
				int[] temp = new int[4];
				int idx = 0;
				// 오른쪽부터 읽어서 temp에 담음 (벽 쪽이 0번 인덱스)
				for (int j = 3; j >= 0; j--) {
					if (grid[i][j] != 0) {
						temp[idx++] = grid[i][j];
					}
				}
				// 합치기
				for (int j = 0; j < 3; j++) {
					if (temp[j] != 0 && temp[j] == temp[j + 1]) {
						temp[j] *= 2;
						temp[j + 1] = 0;
					}
				}
				// 다시 그리드에 오른쪽부터 채워넣기
				int[] finalRow = new int[4];
				idx = 0;
				for (int j = 0; j < 4; j++) {
					if (temp[j] != 0)
						finalRow[idx++] = temp[j];
				}
				// 초기화 후 반영
				for (int j = 0; j < 4; j++)
					grid[i][j] = 0;

				int fillIdx = 3;
				for (int j = 0; j < 4; j++) {
					if (finalRow[j] != 0)
						grid[i][fillIdx--] = finalRow[j];
				}
			}
		} else if (dir == 'U') {
			for (int j = 0; j < 4; j++) {
				int[] temp = new int[4];
				int idx = 0;
				// 위에서부터 읽기
				for (int i = 0; i < 4; i++) {
					if (grid[i][j] != 0) {
						temp[idx++] = grid[i][j];
					}
				}
				// 합치기
				for (int i = 0; i < 3; i++) {
					if (temp[i] != 0 && temp[i] == temp[i + 1]) {
						temp[i] *= 2;
						temp[i + 1] = 0;
					}
				}
				// 다시 그리드에 위에서부터 반영
				int[] finalCol = new int[4];
				idx = 0;
				for (int i = 0; i < 4; i++) {
					if (temp[i] != 0)
						finalCol[idx++] = temp[i];
				}
				for (int i = 0; i < 4; i++) {
					grid[i][j] = finalCol[i];
				}
			}
		} else if (dir == 'D') {
			for (int j = 0; j < 4; j++) {
				int[] temp = new int[4];
				int idx = 0;
				// 아래에서부터 읽기
				for (int i = 3; i >= 0; i--) {
					if (grid[i][j] != 0) {
						temp[idx++] = grid[i][j];
					}
				}
				// 합치기
				for (int i = 0; i < 3; i++) {
					if (temp[i] != 0 && temp[i] == temp[i + 1]) {
						temp[i] *= 2;
						temp[i + 1] = 0;
					}
				}
				// 다시 그리드에 아래에서부터 반영
				int[] finalCol = new int[4];
				idx = 0;
				for (int i = 0; i < 4; i++) {
					if (temp[i] != 0)
						finalCol[idx++] = temp[i];
				}
				// 초기화 후 반영
				for (int i = 0; i < 4; i++)
					grid[i][j] = 0;

				int fillIdx = 3;
				for (int i = 0; i < 4; i++) {
					if (finalCol[i] != 0)
						grid[fillIdx--][j] = finalCol[i];
				}
			}
		}

		// 결과 출력
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 4; j++) {
				System.out.print(grid[i][j] + " ");
			}
			System.out.println();
		}
	}
}