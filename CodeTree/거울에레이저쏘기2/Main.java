package 박민규.CodeTree.거울에레이저쏘기2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		char[][] grid = new char[n][n];
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < n; j++) {
				grid[i][j] = s.charAt(j);
			}
		}
		int startNum = sc.nextInt();
		int idx = 0; // 시작 인덱스
		int direction = (startNum - 1) / n; // 시작 방향
		if (direction >= 2) {
			idx = n - ((startNum - 1) % n) - 1;
		} else {
			idx = (startNum - 1) % n;
		}

		int r = 0, c = 0;
		if (direction == 0) {
			r = 0;
			c = idx;
		} else if (direction == 1) {
			r = idx;
			c = n - 1;
		} else if (direction == 2) {
			r = n - 1;
			c = idx;
		} else {
			r = idx;
			c = 0;
		}

		int cnt = 0;
		while (!(r < 0 || c < 0 || r >= n || c >= n)) {
			switch (direction) { // direction : 0 (아래를 향함) 1(왼쪽을 향함) 2(위를 향함) 3(오른쪽을 향함)
			case 0: {
				if (grid[r][c] == '/') {
					// 왼쪽으로
					direction = 1;
					c--;

				} else { // '\'의 경우
					// 오른쪽으로
					direction = 3;
					c++;
				}
				cnt++;
				break;
			}
			case 1: {
				if (grid[r][c] == '/') {
					// 아래로
					direction = 0;
					r++;

				} else { // '\'의 경우
					// 위로
					direction = 2;
					r--;
				}
				cnt++;
				break;
			}
			case 2: {
				if (grid[r][c] == '/') {
					// 오른쪽으로
					direction = 3;
					c++;

				} else { // '\'의 경우
					// 왼쪽으로
					direction = 1;
					c--;
				}
				cnt++;
				break;
			}
			case 3: {
				if (grid[r][c] == '/') {
					// 위로
					direction = 2;
					r--;

				} else { // '\'의 경우
					// 아래로
					direction = 0;
					r++;
				}
				cnt++;
				break;
			}
			}

		}
		System.out.println(cnt);

	}
}