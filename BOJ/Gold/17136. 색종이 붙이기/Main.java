import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int[][] grid = new int[10][10];
	static List<int[]> ones = new ArrayList<>();
	static int[] paperCnt = { 0, 5, 5, 5, 5, 5 };
	static int minV = Integer.MAX_VALUE;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int i = 0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 10; j++) {
				grid[i][j] = Integer.parseInt(st.nextToken());
				if (grid[i][j] == 1) {
					ones.add(new int[] { i, j });
				}
			}
		}

		solve(0, 0);

		if (minV == Integer.MAX_VALUE)
			System.out.println(-1);
		else {
			System.out.println(minV);
		}

	}

	static void solve(int idx, int usedCnt) {
		if (idx == ones.size()) {
			if (minV > usedCnt)
				minV = usedCnt;
			return;
		}

		int x = ones.get(idx)[0];
		int y = ones.get(idx)[1];
		if (grid[x][y] == 1) {
			for (int size = 5; size > 0; size--) {
				if (paperCnt[size] > 0 && isGood(x, y, size)) {
					draw(x, y, size, 2);
					paperCnt[size]--;

					solve(idx + 1, usedCnt + 1);

					paperCnt[size]++;
					draw(x, y, size, 1);
				}
			}
		} else if (grid[x][y] == 2) {
			solve(idx + 1, usedCnt);
		}

	}

	static boolean isGood(int x, int y, int size) {
		if (x + size - 1 >= 10 || y + size - 1 >= 10)
			return false;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (grid[x + i][y + j] != 1) {
					return false;
				}
			}
		}
		return true;
	}

	static void draw(int x, int y, int size, int state) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				grid[x + i][y + j] = state;
			}
		}
	}

}