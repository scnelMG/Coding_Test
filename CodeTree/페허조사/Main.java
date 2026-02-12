package 박민규.CodeTree.페허조사;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		String s = sc.next();

		int[][] grid = new int[K][2];
		for (int i = 0; i < K; i++) {
			grid[i][0] = sc.nextInt();
			grid[i][1] = sc.nextInt();
		}
		int x = 0, y = 0;
		boolean isGood = true;
		for (int i = 0; i < s.length(); i++) {
			char cmd = s.charAt(i);
			switch (cmd) {
			case 'W':
				isGood = true;
				for (int j = 0; j < K; j++) {
					if (x - 1 < 0 || (x - 1 == grid[j][0] && y == grid[j][1])) {
						isGood = false;
						break;
					}
				}
				if (isGood) {
					x--;
				}
				break;

			case 'A':
				isGood = true;
				for (int j = 0; j < K; j++) {
					if (y - 1 < 0 || x == grid[j][0] && y - 1 == grid[j][1]) {
						isGood = false;
						break;
					}
				}
				if (isGood) {
					y--;
				}
				break;
			case 'S':
				isGood = true;
				for (int j = 0; j < K; j++) {
					if (x + 1 > 30000 || x + 1 == grid[j][0] && y == grid[j][1]) {
						isGood = false;
						break;
					}
				}
				if (isGood) {
					x++;
				}
				break;
			case 'D':
				isGood = true;
				for (int j = 0; j < K; j++) {
					if (y + 1 > 30000 || x == grid[j][0] && y + 1 == grid[j][1]) {
						isGood = false;
						break;
					}
				}
				if (isGood) {
					y++;
				}
				break;
			}

		}
		System.out.println(x + " " + y);
	}
}