package 박민규.CodeTree.사각형의총넓이2;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] x1 = new int[n];
		int[] y1 = new int[n];
		int[] x2 = new int[n];
		int[] y2 = new int[n];

		int[][] grid = new int[201][201];

		for (int i = 0; i < n; i++) {
			x1[i] = sc.nextInt();
			y1[i] = sc.nextInt();
			x2[i] = sc.nextInt();
			y2[i] = sc.nextInt();

			for (int j = x1[i]; j < x2[i]; j++) {
				for (int k = y1[i]; k < y2[i]; k++) {
					grid[j + 100][k + 100] = 1;
				}
			}

		}
		int res = 0;
		for (int j = 0; j < grid.length; j++) {
			for (int k = 0; k < grid.length; k++) {
				if (grid[j][k] == 1)
					res++;
			}
		}
		System.out.println(res);

	}
}