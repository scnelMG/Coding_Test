package 박민규.CodeTree.되돌아오기2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String commands = sc.next();

		int[] dx = { 0, 1, 0, -1 };
		int[] dy = { 1, 0, -1, 0 };

		int x = 0;
		int y = 0;

		int cnt = 0;

		int dIdx = 0;

		for (int i = 0; i < commands.length(); i++) {
			char d = commands.charAt(i);
			if (d == 'L') { // 왼쪽 90도
				dIdx--;
				if (dIdx < 0) {
					dIdx += 4;
				}

			} else if (d == 'R') { // 오른쪽 90도
				dIdx++;
				if (dIdx >= 4) {
					dIdx -= 4;
				}

			} else { // 직진
				x += dx[dIdx];
				y += dy[dIdx];
			}

			if (x == 0 && y == 0) {
				System.out.println(i + 1);
				break;
			}
		}

		if (x != 0 || y != 0)
			System.out.println(-1);
	}
}