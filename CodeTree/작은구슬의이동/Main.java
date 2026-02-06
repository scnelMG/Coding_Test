package 박민규.CodeTree.작은구슬의이동;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int T = sc.nextInt();
		int R = sc.nextInt();
		int C = sc.nextInt();
		String D = sc.next();

		int[] dr = { -1, 1, 0, 0 }; // 상하좌우
		int[] dc = { 0, 0, -1, 1 };

		int[][] grid = new int[N][N];
		R--;
		C--;
		for (int i = 0; i < T; i++) {
			switch (D) {
			case "U": { // 윗쪽
				if (R + dr[0] < 0) { // 범위 넘으면 방향 바꾸기
					D = "D";
				} else {
					R += dr[0];
					C += dc[0];
				}
				break;

			}
			case "D": { // 아래쪽
				if (R + dr[1] >= N) {
					D = "U";
				} else {
					R += dr[1];
					C += dc[1];
				}
				break;
			}
			case "L": { // 왼쪽
				if (C + dc[2] < 0) {
					D = "R";
				} else {
					R += dr[2];
					C += dc[2];
				}
				break;
			}
			case "R": { // 오른쪽
				if (C + dc[3] >= N) {
					D = "L";
				} else {
					R += dr[3];
					C += dc[3];
				}
				break;
			}
			}
		}
		System.out.println((R + 1) + " " + (C + 1));

	}
}