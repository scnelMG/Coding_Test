package 박민규.CodeTree.주사위던지기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int r = sc.nextInt() - 1;
		int c = sc.nextInt() - 1;

		int[][] grid = new int[n][n];
		int up = 1, front = 2, right = 3;

		grid[r][c] = 7 - up;

		for (int i = 0; i < m; i++) {
			String dir = sc.next();
			int nr = r, nc = c;

			if (dir.equals("L"))
				nc = c - 1;
			else if (dir.equals("R"))
				nc = c + 1;
			else if (dir.equals("U"))
				nr = r - 1;
			else if (dir.equals("D"))
				nr = r + 1;
			if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
				continue;
			}

			r = nr;
			c = nc;

			int temp;
			if (dir.equals("L")) {
				// 왼쪽으로 굴림: 오른쪽면 -> 윗면, 윗면 -> 왼쪽면(새 오른쪽은 7-up)
				temp = up;
				up = right;
				right = 7 - temp;
			} else if (dir.equals("R")) {
				// 오른쪽으로 굴림: 왼쪽면(7-right) -> 윗면, 윗면 -> 오른쪽면
				temp = up;
				up = 7 - right;
				right = temp;
			} else if (dir.equals("U")) {
				// 위로 굴림: 앞면 -> 윗면, 윗면 -> 뒷면(새 앞면은 7-up)
				temp = up;
				up = front;
				front = 7 - temp;
			} else if (dir.equals("D")) {
				// 아래로 굴림: 뒷면(7-front) -> 윗면, 윗면 -> 앞면
				temp = up;
				up = 7 - front;
				front = temp;
			}
			grid[r][c] = 7 - up;

		}

		int sum = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				sum += grid[i][j];
			}
		}
		System.out.println(sum);
	}
}
