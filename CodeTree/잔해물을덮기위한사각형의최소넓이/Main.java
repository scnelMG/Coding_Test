package 박민규.CodeTree.잔해물을덮기위한사각형의최소넓이;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int rect1_x1 = sc.nextInt();
		int rect1_y1 = sc.nextInt();
		int rect1_x2 = sc.nextInt();
		int rect1_y2 = sc.nextInt();
		int rect2_x1 = sc.nextInt();
		int rect2_y1 = sc.nextInt();
		int rect2_x2 = sc.nextInt();
		int rect2_y2 = sc.nextInt();

		int[][] grid = new int[2001][2001];
		for (int i = rect1_x1; i < rect1_x2; i++) {
			for (int j = rect1_y1; j < rect1_y2; j++) {
				grid[i + 1000][j + 1000] = 1;
			}
		}

		for (int i = rect2_x1; i < rect2_x2; i++) {
			for (int j = rect2_y1; j < rect2_y2; j++) {
				grid[i + 1000][j + 1000] = 0;
			}
		}

		int max_x = -1, min_x = 10000;
		int max_y = -1, min_y = 10000;
		boolean isClear = true;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[0].length; j++) {
				if (grid[i][j] == 1) {

					if (i > max_x)
						max_x = i;
					if (j > max_y)
						max_y = j;
					if (i < min_x)
						min_x = i;
					if (j < min_y)
						min_y = j;
					isClear = false;
				}
			}
		}
		int res = 0;
		if (isClear)
			res = 0;
		else
			res = (max_x - min_x + 1) * (max_y - min_y + 1);

		System.out.println(res);

	}
}