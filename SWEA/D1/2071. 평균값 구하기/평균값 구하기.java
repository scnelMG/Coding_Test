import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int i = 0; i < T; i++) {
			double res = 0;
			for (int j = 0; j < 10; j++) {
				int num = sc.nextInt();
				res += num;
			}
			res /= 10;
			System.out.printf("#%d %.0f\n", i + 1, res);
		}

	}
}