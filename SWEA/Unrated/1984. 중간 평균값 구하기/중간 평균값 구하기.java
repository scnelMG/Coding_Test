import java.util.Scanner;
import java.io.FileInputStream;

class Solution {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {
			double res = 0;
			int max_v = 0;
			int min_v = 1000000;
			for (int i = 0; i < 10; i++) {
				int num = sc.nextInt();
				if (max_v < num) {
					max_v = num;
				}
				if (min_v > num) {
					min_v = num;
				}
				res += num;
			}
			res = (res - max_v - min_v) / 8;
			System.out.printf("#%d %.0f\n", test_case, res);
		}
	}
}